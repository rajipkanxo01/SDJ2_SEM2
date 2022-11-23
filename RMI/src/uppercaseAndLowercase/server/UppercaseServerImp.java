package uppercaseAndLowercase.server;

import uppercaseAndLowercase.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UppercaseServerImp implements UpperCaseServer {

    public UppercaseServerImp() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toUpperCase(String str)  {
        return str.toUpperCase();
    }
}
