package multipleBridges.client;

import java.rmi.RemoteException;
import java.util.Scanner;

public class StartClient {
    public static void main(String[] args) {
        RemoteClient client = new RemoteClient();

        client.startClient();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("UpperCase or RandomCase? ");
            String chooseCase = sc.nextLine();

            System.out.println("Type your string: ");
            String input = sc.nextLine();
            if (chooseCase.equalsIgnoreCase("uppercase")) {
                try {
                    client.changeToUpperCase(input);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            } else if (chooseCase.equalsIgnoreCase("randomcase")) {
                try {
                    client.changingToRandomCase(input);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Invalid Request!!!");
            }
        }
    }
}
