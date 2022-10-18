package multiClientsWithId.client;

import multiClientsWithId.shared.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocketHandler implements Runnable {
    private Socket socket;
    private IdClient client;
    ObjectInputStream inFromServer;
    ObjectOutputStream outToServer;

    private String id;

    public ClientSocketHandler(Socket socket) {
        this.socket = socket;
        try {
            inFromServer = new ObjectInputStream(socket.getInputStream());
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (IOException  e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            id = (String) inFromServer.readObject();
            System.out.println("Your Client Id is: " + id);

            while (true) {
                Message msgToServer = new Message("Hello from client number: " + id);
                outToServer.writeObject(msgToServer);
                Message response = (Message) inFromServer.readObject();
                System.out.println(response);

            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
