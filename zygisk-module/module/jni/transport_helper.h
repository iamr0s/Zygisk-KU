//
// Created by iamr0s on 2022/6/20.
//

#ifndef ZYGISK_MODULE_TRANSPORT_HELPER_H
#define ZYGISK_MODULE_TRANSPORT_HELPER_H

#include <string>

#include "transport.h"

using namespace std;

namespace zygisk_module {
    enum TransportType {
        EXIT = 0,
        READ_FILE,
        WRITE_FILE,
        SYSTEM,
    };

    class TransportHelper {
    public:
        static string read_file_client(Transport, const string &);

        static void read_file_server(Transport);

        static void write_file_client(
                Transport,
                const string &,
                int,
                unsigned short,
                const string &
        );

        static void write_file_server(Transport);

        static void exit_client(Transport);

        static void system_server(Transport);

        static void systemt_client(Transport, const string &);
    };
}


#endif //ZYGISK_MODULE_TRANSPORT_HELPER_H
