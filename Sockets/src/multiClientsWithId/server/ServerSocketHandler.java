package multiClientsWithId.server;

import multiClientsWithId.shared.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable {
    private Socket socket;
    ObjectInputStream inFromClient;
    ObjectOutputStream outToClient;

    private int id;

    public ServerSocketHandler(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
        try {
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {

        try {
            outToClient.writeObject(String.valueOf(id));

            while (true) {
                // message read from client
                Message readObject = (Message) inFromClient.readObject();
                System.out.println(readObject);

                // sending reply to client
                Message reply = new Message("And, Hello to you, client number" + id);
                outToClient.writeObject(reply);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
