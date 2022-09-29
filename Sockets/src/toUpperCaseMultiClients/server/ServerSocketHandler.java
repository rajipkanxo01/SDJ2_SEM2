package toUpperCaseMultiClients.server;

import toUpperCaseMultiClients.utils.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable {
    private Socket socket;
    private ConnectionPool connectionPool;
    private ObjectInputStream inFromClient;
    private ObjectOutputStream outToClient;

    public ServerSocketHandler(Socket socket, ConnectionPool connectionPool) {
        this.socket = socket;
        this.connectionPool = connectionPool;
        try {
            inFromClient = new ObjectInputStream(socket.getInputStream());
            outToClient = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message read = (Message) inFromClient.readObject();
                System.out.println("Received from client: " + read);

                if (read.getMessageBody().equalsIgnoreCase("exit")) {
                    socket.close();
                    System.out.println("Client Disconnected!!!!!!!");
                    connectionPool.removeClient(this);
                    break;
                }

                String result = read.getMessageBody().toUpperCase();
                Message m = new Message(result);
                connectionPool.broadcast(m);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void sendMessage(Message message) {
        try {
            outToClient.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

