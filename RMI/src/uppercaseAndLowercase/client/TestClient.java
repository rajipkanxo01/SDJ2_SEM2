package uppercaseAndLowercase.client;

import java.util.Scanner;

public class TestClient {
    public static void main(String[] args) {
        RMIClient client = new RMIClient();
        client.startClient();

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Uppercase or Lowercase?");
            String string = input.nextLine();

            System.out.println("Type your String:");
            String read = input.nextLine();
            if (read.equalsIgnoreCase("exit")) break;

            String result = "";
            if (string.equalsIgnoreCase("uppercase")) {
                result = client.toUpperCase(read);
            } else if (string.equalsIgnoreCase("Lowercase")) {
                result = client.toLowerCase(read);
            } else {
                result = "Invalid Request";
            }
            System.out.println("Result: " + result);
        }
    }
}
