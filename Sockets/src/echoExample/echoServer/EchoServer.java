package echoExample.echoServer;

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

                ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());

                String readObject = (String) inFromClient.readObject();
                System.out.println("Client choose: " + readObject);

                String result = readObject.toUpperCase();
                outToClient.writeObject(result);

            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}