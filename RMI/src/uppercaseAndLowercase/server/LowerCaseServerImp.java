package uppercaseAndLowercase.server;

import uppercaseAndLowercase.shared.LowerCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LowerCaseServerImp implements LowerCaseServer {

    public LowerCaseServerImp() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toLowerCase(String arg)  {
        return arg.toLowerCase();
    }
}
