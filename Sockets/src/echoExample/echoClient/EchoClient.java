package echoExample.echoClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    public void runClient() {
        try {
            // Creating a socket that is connected to the server.
            Socket socket = new Socket("localhost", 8500); //local host is own ip address

            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            outToServer.writeObject(input);
            String result = (String) inFromServer.readObject();
            System.out.println("Received from server: " + result);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
