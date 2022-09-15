package upperCaseLowerCase.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CaseServer {
    public void start() {
        System.out.println("Starting server............\n");
        try {
            ServerSocket serverSocket = new ServerSocket(8500);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client Connected.........\n");

                ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());

                while (true) {
                    outToClient.writeObject("How can I help? (UpperCase or LowerCase)");

                    String readObject = (String) inFromClient.readObject();
                    System.out.println("Client choose: " + readObject);

                    if (readObject.equalsIgnoreCase("uppercase")) {
                        outToClient.writeObject("You chose uppercase. Write your argument!");
                        String input = (String) inFromClient.readObject();
                        outToClient.writeObject(input.toUpperCase());
                    } else if (readObject.equalsIgnoreCase("lowercase")) {
                        outToClient.writeObject("You chose lowercase. Write your argument!");
                        String input = (String) inFromClient.readObject();
                        outToClient.writeObject(input.toLowerCase());
                    } else if (readObject.equalsIgnoreCase("stop")) {
                        outToClient.writeObject("You chose to stop");
                        break;
                    } else {
                        outToClient.writeObject("Invalid Text");
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}