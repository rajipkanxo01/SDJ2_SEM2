package chatExampleMulti.client;

import chatExampleMulti.shared.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class ChatClient {

    private ObjectInputStream inFromServer;
    private ObjectOutputStream outToServer;

    public void start() {
        try {
            Socket socket = new Socket("localhost", 2002);
            outToServer = new ObjectOutputStream(socket.getOutputStream());
            inFromServer = new ObjectInputStream(socket.getInputStream());

            Thread thread = new Thread(() -> listenToServer());
            thread.setDaemon(true);
            thread.start();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Insert Username:");
            String username = scanner.nextLine();
            outToServer.writeObject(username);


            while (true) {
                System.out.println("Input Message:");
                String message = scanner.nextLine();
                Message msg = new Message(message, username);

                outToServer.writeObject(msg);

                if (message.equalsIgnoreCase("exit")) {
                    socket.close();
                    break;
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listenToServer() {
        try {
            while (true) {
                Message response = (Message) inFromServer.readObject();
                System.out.println(response);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
