package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty();
                         str = in.readLine()) {
                        System.out.println(str);
                        if (str.contains("msg=")) {
                            String msg = str.substring(10, str.length() - 9);
                            if (msg.equals("Hello")) {
                                out.write("Hello\n".getBytes());
                            } else if (msg.equals("Exit")) {
                                server.close();
                            } else {
                                out.write("What?\n".getBytes());
                            }
                        }
                    }
                    out.flush();
                }
            }
        } catch (Exception e) {
            LOG.error("EchoServer exception in log", e);
        }
    }
}