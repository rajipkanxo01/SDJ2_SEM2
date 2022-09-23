package oneToOneChatSystem.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public void startChat() {
        try {
            Socket socket = new Socket("10.154.210.27", 2222);

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            System.out.println("Type end if you want to end this conversation!! \n");
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Enter your message to server:");

                String msgToServer = sc.nextLine();
                out.writeObject(msgToServer);

                if (msgToServer.equals("end")) {
                    System.out.println("Conversation Terminated!!!!!");
                    return;
                }

                String msgFromServer = (String) in.readObject();
                System.out.println("\nServer Says: " + msgFromServer + "\n");
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
