package multiClientsWithId.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class IdServer {

    public void startServer () {
        int id = 0;
        try {
            ServerSocket serverSocket = new ServerSocket(2002);
            System.out.println("Server Started....");

            while (true) {
                Socket socket = serverSocket.accept();

                ServerSocketHandler serverSocketHandler = new ServerSocketHandler(socket,id);
                Thread thread = new Thread(serverSocketHandler);
                thread.start();

                id++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
