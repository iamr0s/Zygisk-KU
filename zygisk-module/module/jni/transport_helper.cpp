//
// Created by iamr0s on 2022/6/20.
//
#include <string>
#include <unistd.h>
#include <fcntl.h>

#include "transport_helper.h"
#include "transport.h"

using namespace std;

namespace zygisk_module {
    void TransportHelper::read_file_server(Transport transport) {
        auto filename = transport.receive_string();
        if (transport.ret < 0) return;
        unsigned long file_size = 0L;
        auto file_fd = open(filename.c_str(), O_RDONLY);
        if (file_fd < 0) {
            transport.send(file_size);
            return;
        }
        file_size = lseek(file_fd, 0, SEEK_END);
        lseek(file_fd, 0, SEEK_SET);
        transport.send(file_size);
        transport.send(transport.remote_fd, file_fd, nullptr, file_size);
        close(file_fd);
    }

    string TransportHelper::read_file_client(Transport transport, const string &filename) {
        transport.send(TransportType::READ_FILE);
        transport.send(filename);
        return transport.receive_string();
    }

    void TransportHelper::write_file_server(Transport transport) {
        auto filename = transport.receive_string();
        if (transport.ret < 0) return;
        auto flags = transport.receive_int();
        if (transport.ret < 0) return;
        auto modes = transport.receive_unsigned_short();
        if (transport.ret < 0) return;
        auto bytes = transport.receive_string();
        if (transport.ret < 0) return;
        auto file_fd = open(filename.c_str(), flags, modes);
        write(file_fd, bytes.data(), bytes.size());
        close(file_fd);
    }

    void TransportHelper::write_file_client(
            Transport transport,
            const string &filename,
            int flags,
            unsigned short modes,
            const string &bytes
    ) {
        transport.send(TransportType::WRITE_FILE);
        transport.send(filename);
        transport.send(flags);
        transport.send(modes);
        transport.send(bytes);
    }

    void TransportHelper::exit_client(Transport transport) {
        transport.send(TransportType::EXIT);
        close(transport.remote_fd);
    }

    void TransportHelper::system_server(Transport transport) {
        auto command = transport.receive_string();
        system(command.c_str());
    }

    void TransportHelper::systemt_client(Transport transport, const string &command) {
        transport.send(command);
    }
}
