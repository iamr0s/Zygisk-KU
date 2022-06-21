//
// Created by iamr0s on 2022/6/19.
//

#ifndef ZYGISK_MODULE_TRANSPORT_H
#define ZYGISK_MODULE_TRANSPORT_H

namespace zygisk_module {
    class Transport {
    public:
        int remote_fd;
        int ret;

        Transport(int remote_fd) {
            this->remote_fd = remote_fd;
            this->ret = 0;
        };

        std::string receive_string();

        void send(std::string);

        short receive_short();

        void send(short);

        unsigned short receive_unsigned_short();

        void send(unsigned short);

        int receive_int();

        void send(int);

        unsigned int receive_unsigned_int();

        void send(unsigned int);

        long receive_long();

        void send(long);

        unsigned long receive_unsigned_long();

        void send(unsigned long);

        void send(int, int, off_t *, size_t);
    };
}

#endif //ZYGISK_MODULE_TRANSPORT_H
