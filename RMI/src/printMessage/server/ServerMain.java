package printMessage.server;

import printMessage.shared.TextServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    public static void main(String[] args) {
        TextServer textServer = new RMITextServer();
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("TextServer", textServer);
            System.out.println("Text Server started ....");

        } catch (RemoteException | AlreadyBoundException e) {
            throw new RuntimeException(e);
        }
    }
}
