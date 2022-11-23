package toUpperCaseCallback.server;


import toUpperCaseCallback.shared.UpperCaseClient;
import toUpperCaseCallback.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements UpperCaseServer {

    public ServerImpl() {
        try {
            // export object so object is remotely available
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void toUppercase(String str, UpperCaseClient client) throws RemoteException {
        String result = str.toUpperCase();
        client.uppercaseResult(result);
    }
}
