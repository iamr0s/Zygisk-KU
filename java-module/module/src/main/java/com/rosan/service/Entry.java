package com.rosan.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;

class Entry {
    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            PrintStream stream = new PrintStream(new FileOutputStream(file));

            // random port
            ServerSocket socket = new ServerSocket(0);
            stream.print(socket.getLocalPort());
            stream.flush();
            stream.close();

            socket.accept();
            socket.close();

            file.delete();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
