package chatExampleMulti.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(2002);
            ConnectionPool pool = new ConnectionPool();
            System.out.println("Server Started");

            while (true) {
                Socket socket = serverSocket.accept();

                ServerSocketHandler handler = new ServerSocketHandler(socket, pool);
                pool.addConnections(handler);
                Thread thread = new Thread(handler);
                thread.start();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
