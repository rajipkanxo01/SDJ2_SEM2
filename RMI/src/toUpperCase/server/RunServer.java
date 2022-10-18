package toUpperCase.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer {
    public static void main(String[] args) {
        try {
            ServerImpl server = new ServerImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("UpperCase Server",server);
        } catch (RemoteException | AlreadyBoundException e) {
            throw new RuntimeException(e);
        }
    }
}
