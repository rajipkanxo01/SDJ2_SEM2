package multipleBridges.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    public static void main(String[] args) {
        StringChangingServer server = new StringChangingServer();
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("StringChangingServer",server);
            System.out.println("Server Started.......");
        } catch (RemoteException | AlreadyBoundException e) {
            throw new RuntimeException(e);
        }
    }
}
