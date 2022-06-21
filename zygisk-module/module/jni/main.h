//
// Created by iamr0s on 2022/6/19.
//

#ifndef ZYGISK_MODULE_MAIN_H
#define ZYGISK_MODULE_MAIN_H

#include <experimental/string>
#include <android/log.h>

#include "zygisk.hpp"
#include "transport.h"

using namespace std;
using namespace zygisk;

namespace zygisk_module {
    static constexpr auto TAG = "zygisk_ku_jni";

#ifdef NDEBUG
#define LOGD(...)
#else
#define LOGD(...)     __android_log_print(ANDROID_LOG_DEBUG, TAG, __VA_ARGS__)
#endif

#define LOGI(...)     __android_log_print(ANDROID_LOG_INFO,  TAG, __VA_ARGS__)
#define LOGE(...)     __android_log_print(ANDROID_LOG_ERROR, TAG, __VA_ARGS__)
#define LOGERRNO(...) __android_log_print(ANDROID_LOG_ERROR, TAG, __VA_ARGS__ ": %d (%s)", errno, strerror(errno))

    class Module : public ModuleBase {
    private:
        Api *api;
        JNIEnv *env;
        string dexBytes;
        bool dexLoaded = false;
        int port;
    public:
        void onLoad(Api *, JNIEnv *) override;

        void preServerSpecialize(ServerSpecializeArgs *) override;

        void postServerSpecialize(const ServerSpecializeArgs *) override;

        static void companion_handler(int);
    };
}

#endif //ZYGISK_MODULE_MAIN_H
