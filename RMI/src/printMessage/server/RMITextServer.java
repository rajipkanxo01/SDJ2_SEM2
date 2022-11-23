package printMessage.server;

import printMessage.shared.TextServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMITextServer implements TextServer {
    public RMITextServer() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void printText(String string) throws RemoteException {
        System.out.println(string);
    }
}
