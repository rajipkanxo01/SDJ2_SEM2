package loginSystem.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public void start() {
        System.out.println("Server starting.............");
        try {
            ServerSocket serverSocket = new ServerSocket(5678);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected ..........");

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                String status = (String) in.readObject();
                System.out.println("\nFrom Client: " + status);
                if (!status.equals("connect")) {
                    socket.close();
                }
                out.writeObject("Username?");

                String username = (String) in.readObject();
                System.out.println("\nClients Username: " + username);
                if (!username.equals("rajipkanxo01")) {
                    socket.close();
                }
                out.writeObject("Password?");

                String password = (String) in.readObject();
                System.out.println("\nClients Password: " + password);
                if (!password.equals("0000")) {
                    socket.close();
                }
                out.writeObject("Successfully logged in");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Disconnected");
        }
    }
}
