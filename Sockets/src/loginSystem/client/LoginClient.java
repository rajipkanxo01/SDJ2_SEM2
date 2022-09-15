package loginSystem.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LoginClient {
    public void runClient() {
        try {
            Socket socket = new Socket("localhost", 5678);

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.println("Type message: ");
            String statusInput = scanner.nextLine();
            out.writeObject(statusInput);

            // receives username message
            System.out.println("\nReceived from server: " + in.readObject());

            System.out.println("Type your username:");
            out.writeObject(scanner.nextLine());

            // receives password message
            System.out.println("\nReceived from server: " + in.readObject());

            System.out.println("Type your password:");
            out.writeObject(scanner.nextLine());

            // receives successful message
            System.out.println("\nReceived from server: " + in.readObject());

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Connection Error");
        }
    }
}
