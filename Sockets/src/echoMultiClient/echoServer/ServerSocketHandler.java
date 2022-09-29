package echoMultiClient.echoServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable {
    private ObjectInputStream inFromClient;
    private ObjectOutputStream outToClient;
    private Socket socket;

    public ServerSocketHandler(Socket socket) {
        this.socket = socket;
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
