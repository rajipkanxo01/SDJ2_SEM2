package toUpperCaseCallback.client;


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

            client.toUpperCase(read);
        }
    }
}
