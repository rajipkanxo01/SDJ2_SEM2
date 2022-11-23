package uppercaseAndLowercase.client;

import uppercaseAndLowercase.shared.LowerCaseServer;
import uppercaseAndLowercase.shared.Server;
import uppercaseAndLowercase.shared.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {


    private UpperCaseServer upperCaseServer;
    private Server server;
    private LowerCaseServer lowerCaseServer;

    public RMIClient() {

    }

    public void startClient() {
        // making connection to server
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            server = (Server) registry.lookup("UpperCaseServer");
            upperCaseServer = server.getUpperCaseServer();
            lowerCaseServer = server.getLowerCaseServer();
        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }


    public String toUpperCase(String str) {
        try {
           return   upperCaseServer.toUpperCase(str);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public String toLowerCase(String str) {
        try {
           return lowerCaseServer.toLowerCase(str);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }


}
