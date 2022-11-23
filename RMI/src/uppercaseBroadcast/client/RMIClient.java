package uppercaseBroadcast.client;

import uppercaseBroadcast.shared.UpperCaseClient;
import uppercaseBroadcast.shared.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient implements UpperCaseClient {


    private UpperCaseServer upperCaseServer;

    public RMIClient() {

    }

    public void startClient() {
        // making connection to server
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            upperCaseServer = (UpperCaseServer) registry.lookup("UpperCaseServer");
            upperCaseServer.registerClient(this);
        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }


    public String toUpperCase(String str) {
        try {
            return upperCaseServer.toUpperCase(str, this);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(String result) {
        System.out.println("Broadcasted > " + result);
    }


}
