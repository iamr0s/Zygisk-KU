#include <unistd.h>
#include <fcntl.h>
#include <string>
#include <thread>

#include "main.h"
#include "zygisk.hpp"
#include "transport.h"
#include "transport_helper.h"

using namespace std;
using namespace zygisk;

namespace zygisk_module {
    void Module::onLoad(Api *api, JNIEnv *env) {
        this->api = api;
        this->env = env;
    }

    void Module::preServerSpecialize(ServerSpecializeArgs *args) {
        api->setOption(Option::DLCLOSE_MODULE_LIBRARY);
        LOGI("Module::preServerSpecialize(ServerSpecializeArgs *)");
        Transport transport(api->connectCompanion());
        LOGI("classes.dex loading");
        dexBytes = TransportHelper::read_file_client(
                transport,
                string("/data/adb/modules/KeyguardUnlocked/classes.dex")
        );
        port = atoi(TransportHelper::read_file_client(
                transport,
                string("/data/adb/modules/KeyguardUnlocked/address")
        ).c_str());
        if (transport.ret < 0) {
            LOGI("classes.dex load failed");
            TransportHelper::exit_client(transport);
            return;
        }
        LOGI("classes.dex loaded");
        TransportHelper::exit_client(transport);
        dexLoaded = true;
    }

    void Module::postServerSpecialize(const ServerSpecializeArgs *args) {
        if (!dexLoaded)return;
        LOGI("InMemoryDexClassLoader creating");
        auto classLoaderClazz = env->FindClass("java/lang/ClassLoader");
        auto getSystemClassLoaderMethod = env->GetStaticMethodID(
                classLoaderClazz,
                "getSystemClassLoader",
                "()Ljava/lang/ClassLoader;"
        );
        auto systemClassLoader = env->CallStaticObjectMethod(
                classLoaderClazz,
                getSystemClassLoaderMethod
        );
        auto inMemoryDexClassLoaderClazz = env->FindClass("dalvik/system/InMemoryDexClassLoader");
        auto initMethod = env->GetMethodID(
                inMemoryDexClassLoaderClazz,
                "<init>",
                "(Ljava/nio/ByteBuffer;Ljava/lang/ClassLoader;)V"
        );
        auto classLoader = env->NewObject(
                inMemoryDexClassLoaderClazz, initMethod,
                env->NewDirectByteBuffer(dexBytes.data(), dexBytes.size()),
                systemClassLoader
        );
        auto loadClassMethod = env->GetMethodID(
                inMemoryDexClassLoaderClazz,
                "loadClass",
                "(Ljava/lang/String;)Ljava/lang/Class;"
        );
        auto entryClazz = (jclass) env->CallObjectMethod(
                classLoader, loadClassMethod,
                env->NewStringUTF("com.rosan.zygisk.Entry")
        );
        auto entryMethod = env->GetStaticMethodID(entryClazz, "init",
                                                  "(I)V");
        LOGI("com.rosan.zygisk.Entry->init()V calling");
        env->CallStaticVoidMethod(
                entryClazz,
                entryMethod,
                port
        );
        LOGI("com.rosan.zygisk.Entry->init()V called");
    }

    void Module::companion_handler(int remote_fd) {
        Transport transport(remote_fd);
        auto type = transport.receive_int();
        switch (type) {
            case TransportType::READ_FILE:
                TransportHelper::read_file_server(transport);
                break;
            case TransportType::WRITE_FILE:
                TransportHelper::write_file_server(transport);
                break;
            case TransportType::SYSTEM:
                TransportHelper::system_server(transport);
                break;
            default:
                return;
        }
        companion_handler(remote_fd);
    }
}


REGISTER_ZYGISK_MODULE(zygisk_module::Module);

REGISTER_ZYGISK_COMPANION(zygisk_module::Module::companion_handler);
