package toUpperCaseCallback.server;

import toUpperCaseCallback.shared.UpperCaseServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer {
    public static void main(String[] args) {
        UpperCaseServer upperCaseServer = new ServerImpl();
        try {
            // 1099 is default rmi port
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("UpperCaseServer", upperCaseServer);
            System.out.println("Server Started.........");

        } catch (RemoteException | AlreadyBoundException e) {
            throw new RuntimeException(e);
        }
    }
}
