package multipleBridges.server;

import multipleBridges.shared.IToUpperCase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ToUpperCase implements IToUpperCase {

    public ToUpperCase() {
        try {
            UnicastRemoteObject.exportObject(this,0);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toUpperCase(String str)  {
        return str.toUpperCase();
    }
}
