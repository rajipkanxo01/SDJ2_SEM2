package toUpperCase.client;

import toUpperCase.shared.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient  {


    private UpperCaseServer upperCaseServer;

    public RMIClient() {

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


    public String toUpperCase(String str) {
        try {
           return  upperCaseServer.toUppercase(str);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }


}
