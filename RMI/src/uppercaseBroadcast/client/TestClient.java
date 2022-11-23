package uppercaseBroadcast.client;

import java.util.Scanner;

public class TestClient {
    public static void main(String[] args) {
        RMIClient client = new RMIClient();
        client.startClient();

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Type your String:");
            String read = input.nextLine();
            if (read.equalsIgnoreCase("exit")) break;

            String result = client.toUpperCase(read);
            System.out.println("Result: " + result);
        }
    }
}
