package com.rosan.zygisk;

import android.app.ActivityThread;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.IBinder;
import android.os.ServiceManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;

public class Entry {
    public static String TAG = "zygisk_ku_java";

    public static void log_i(Object ob) {
        Log.i(TAG, "" + ob);
    }

    public static void init(int port) {
        new Thread(() -> {
            do {
                IBinder binder = ServiceManager.getService(Context.ACTIVITY_SERVICE);
                if (binder != null) break;
                log_i("service is not started,wait 1s.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
            ActivityThread currentActivityThread = ActivityThread.currentActivityThread();
            if (currentActivityThread == null) {
                log_i("currentActivityThread is null!!!");
                return;
            }
            Context context = currentActivityThread.getSystemContext();
            if (currentActivityThread == null) {
                log_i("systemContext is null!!!");
                return;
            }
            init(port, context);
        }).start();
    }

    public static void init(int port, Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_USER_PRESENT);
        context.registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                log_i("keyguard unlocked");
                try {
                    notifyKeyguardUnlocked(port);
                } catch (Throwable e) {
                    log_i(e.getMessage());
                }
                context.unregisterReceiver(this);
            }
        }, intentFilter);
    }

    /*public static void main(String[] args) {
        try {
            PrintStream out = new PrintStream(System.out);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
            int port = Integer.parseInt(reader.readLine());
            out.println(port);
            reader.close();
            notifyKeyguardUnlocked(port);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }*/

    private static void notifyKeyguardUnlocked(int port) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(port));
        socket.close();
    }
}
