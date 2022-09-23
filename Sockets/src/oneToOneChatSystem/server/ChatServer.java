package oneToOneChatSystem.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(0204);
            System.out.println("Server Started Successfully");
            while (true) {
                Socket socket = serverSocket.accept();

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                Scanner sc = new Scanner(System.in);
                while (true) {
                    String msgFromClient = (String) in.readObject();

                    if (msgFromClient.equals("end")) {
                        System.out.println("Client Disconnected");
                        socket.close();
                    }
                    System.out.println("\nClient says: " + msgFromClient + "\n");


                    System.out.println("Enter your message to client:");
                    String msgToClient = sc.nextLine();
                    out.writeObject(msgToClient);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }
    }
}
