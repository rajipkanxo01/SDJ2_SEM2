package upperCaseLowerCase.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class UpperCaseLowerCaseClient {

    public void runClient() {
        try {
            // Creating a socket that is connected to the server.
            Socket socket = new Socket("localhost", 8500); //local host is own ip address

            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

            while (true) {
                String read = (String) inFromServer.readObject();
                System.out.println("\n\nReceived from server: " + read);

                Scanner scanner = new Scanner(System.in);
                System.out.println("Type your message: ");
                String message = scanner.nextLine();
                outToServer.writeObject(message);
                System.out.println("Received from server: " + inFromServer.readObject());

                System.out.println("Write your Argument?");
                String input = scanner.nextLine();

                if (input.equals("stop")) {

                    socket.close();
                }

                outToServer.writeObject(input);
                String result = (String) inFromServer.readObject();
                System.out.println("Received from server: " + result);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Disconnected from server");
        }
    }
}
