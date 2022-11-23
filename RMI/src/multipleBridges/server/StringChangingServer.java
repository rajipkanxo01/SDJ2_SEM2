package multipleBridges.server;

import multipleBridges.shared.IStringChangingServer;
import multipleBridges.shared.IToRandomCase;
import multipleBridges.shared.IToUpperCase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringChangingServer implements IStringChangingServer {

    public StringChangingServer() {
        try {
            UnicastRemoteObject.exportObject(this,0);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public IToUpperCase getUpperCase() {
        return new ToUpperCase();
    }

    @Override
    public IToRandomCase getRandomCase() {
        return new ToRandomCase();
    }
}
