package calculator.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Calculator {
    public void runCalculator() {
        try {
            Socket socket = new Socket("localhost", 0204);

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            System.out.println("\nResponse from server: " + in.readObject());

            Scanner sc = new Scanner(System.in);

            System.out.println("Response from server: " + in.readObject());
            int first = sc.nextInt();
            out.writeInt(first);

            System.out.println("Response from server: " + in.readObject());
            int second = sc.nextInt();
            out.writeInt(second);

            System.out.println("Response from server: " + in.readObject());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
