package toUpperCase.client;

import toUpperCase.shared.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientImpl {
    private UpperCaseServer server;

    public ClientImpl() {

    }

    public void initializeConnection () {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",1099);
            server = (UpperCaseServer) registry.lookup("UpperCase Server");
        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String toUpperCase (String obj) {
        try {
            return server.toUpperCase(obj);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
