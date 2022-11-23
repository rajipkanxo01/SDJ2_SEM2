package multipleBridges.client;

import multipleBridges.shared.IStringChangingServer;
import multipleBridges.shared.IToRandomCase;
import multipleBridges.shared.IToUpperCase;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteClient {
    private IToUpperCase upperCase;
    private IToRandomCase randomCase;
    private IStringChangingServer changingServer;

    public RemoteClient() {
    }

    public void startClient() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            changingServer = (IStringChangingServer) registry.lookup("StringChangingServer");

            upperCase = changingServer.getUpperCase();
            randomCase = changingServer.getRandomCase();

        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void changeToUpperCase(String str) throws  RemoteException {
        try {
            System.out.println(upperCase.toUpperCase(str));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void changingToRandomCase(String str) throws RemoteException {
        try {
            System.out.println(randomCase.toRandomCase(str));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }


}
