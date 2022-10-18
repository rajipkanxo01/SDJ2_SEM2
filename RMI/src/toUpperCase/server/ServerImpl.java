package toUpperCase.server;

import toUpperCase.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements UpperCaseServer {

    public ServerImpl() {
        try {
            UnicastRemoteObject.exportObject(this,1099);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toUpperCase(String arg)  {
        return arg.toUpperCase();
    }
}
