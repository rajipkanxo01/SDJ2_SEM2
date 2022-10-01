package chatExampleMulti.server;

import chatExampleMulti.shared.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable {
    private Socket socket;
    private ObjectInputStream inFromClient;
    private ObjectOutputStream outToClient;
    private ConnectionPool pool;
    private String userName;

    public ServerSocketHandler(Socket socket, ConnectionPool pool) {
        this.socket = socket;
        this.pool = pool;
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
            userName = (String) inFromClient.readObject();
            while (true) {
                Message msg = (Message) inFromClient.readObject();
                System.out.println(msg);

                if (msg.getMessageBody().equalsIgnoreCase("exit")) {
                    pool.removeConnection(this);
                    socket.close();
                    break;
                }


                pool.broadcast(msg);

            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessageToClient(Message msg) {
        try {
            outToClient.writeObject(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getClientName() {
        return  userName;
    }
}
