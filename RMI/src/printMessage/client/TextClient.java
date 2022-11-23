package printMessage.client;

import printMessage.shared.TextServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TextClient {
    private TextServer textServer;

    public TextClient() {

    }

    public void startClient() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            textServer = (TextServer) registry.lookup("TextServer");

        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendText(String text) {
        try {

            textServer.printText(text);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
