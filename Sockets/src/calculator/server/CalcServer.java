package calculator.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer {
    public void run() {
        System.out.println("Server starting...........");

        try {
            ServerSocket serverSocket = new ServerSocket(0204);

            while (true) {
                Socket socket = serverSocket.accept();

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                out.writeObject("Connected Successfully!!!");

                out.writeObject("Enter your first number");
                System.out.println(in.readInt());
                int first = in.readInt();
//                int first = (int) in.readObject();
                out.writeObject("Enter your second number");
//                int second = (int) in.readObject();
                int second = in.readInt();
                int sum = first + second;

                out.writeObject("Your total sum is: " + sum);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
