package echoMultiClient.echoServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public void start() {
        System.out.println("Starting server............\n");
        try {
            ServerSocket serverSocket = new ServerSocket(8500);


            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client Connected.........\n");

                ServerSocketHandler ssh = new ServerSocketHandler(socket);
                Thread t = new Thread(ssh);
                t.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}