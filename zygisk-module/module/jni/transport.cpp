//
// Created by iamr0s on 2022/6/19.
//
#include <vector>
#include <unistd.h>
#include <string>
#include <sys/sendfile.h>

#include "transport.h"

using namespace std;

namespace zygisk_module {
    string Transport::receive_string() {
        string str;
        if (ret < 0)return str;

        auto size = receive_unsigned_long();
        if (size < 0 || ret < 0) return str;

        str.resize(size);
        int received = 0;
        while (received < size) {
            ret = read(remote_fd, str.data() + received, size - received);
            if (ret < 0) {
                return str;
            }
            received += ret;
        }
        if (ret < 0) return str;
        return str;
    }

    void Transport::send(string str) {
        if (ret < 0)return;
        unsigned long size = str.size();

        send(size);
        if (ret < 0) return;

        int sent = 0;
        while (sent < size) {
            ret = write(remote_fd, str.data() + sent, size - sent);
            if (ret < 0) {
                return;
            }
            sent += ret;
        }
        if (ret < 0) return;
    }

    short Transport::receive_short() {
        short s;
        if (ret < 0)return s;
        ret = read(remote_fd, &s, sizeof(s));
        return s;
    }

    void Transport::send(short s) {
        if (ret < 0)return;
        ret = write(remote_fd, &s, sizeof(s));
    }

    unsigned short Transport::receive_unsigned_short() {
        unsigned short s;
        if (ret < 0)return s;
        ret = read(remote_fd, &s, sizeof(s));
        return s;
    }

    void Transport::send(unsigned short s) {
        if (ret < 0)return;
        ret = write(remote_fd, &s, sizeof(s));
    }

    int Transport::receive_int() {
        int i;
        if (ret < 0)return i;
        ret = read(remote_fd, &i, sizeof(i));
        return i;
    }

    void Transport::send(int i) {
        if (ret < 0)return;
        ret = write(remote_fd, &i, sizeof(i));
    }

    unsigned int Transport::receive_unsigned_int() {
        unsigned int i;
        if (ret < 0)return i;
        ret = read(remote_fd, &i, sizeof(i));
        return i;
    }

    void Transport::send(unsigned int i) {
        if (ret < 0)return;
        ret = write(remote_fd, &i, sizeof(i));
    }

    long Transport::receive_long() {
        long l;
        if (ret < 0)return l;
        ret = read(remote_fd, &l, sizeof(l));
        return l;
    }

    void Transport::send(long l) {
        if (ret < 0)return;
        ret = write(remote_fd, &l, sizeof(l));
    }

    unsigned long Transport::receive_unsigned_long() {
        unsigned long l;
        if (ret < 0)return l;
        ret = read(remote_fd, &l, sizeof(l));
        return l;
    }

    void Transport::send(unsigned long l) {
        if (ret < 0)return;
        ret = write(remote_fd, &l, sizeof(l));
    }

    void Transport::send(int out_fd, int in_fd, off_t *__offset, size_t size) {
        if (ret < 0)return;
        ret = sendfile(out_fd, in_fd, __offset, size);
    }
}
