package toUpperCaseCallback.client;

import toUpperCaseCallback.shared.UpperCaseClient;
import toUpperCaseCallback.shared.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient implements UpperCaseClient {


    private UpperCaseServer upperCaseServer;

    public RMIClient() {
        try {
            UnicastRemoteObject.exportObject(this,0);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void startClient() {
        // making connection to server
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            upperCaseServer = (UpperCaseServer) registry.lookup("UpperCaseServer");
        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void toUpperCase(String str) {
        try {
            upperCaseServer.toUppercase(str, this);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void uppercaseResult(String result) throws RemoteException {
        // asynchronous call
        System.out.println("Result: " + result);
    }
}
