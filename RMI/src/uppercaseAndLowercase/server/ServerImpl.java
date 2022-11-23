package uppercaseAndLowercase.server;

import uppercaseAndLowercase.shared.LowerCaseServer;
import uppercaseAndLowercase.shared.Server;
import uppercaseAndLowercase.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements Server {

    public ServerImpl() {

        try {
            // export object so object is remotely available
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public UpperCaseServer getUpperCaseServer() {
        return new UppercaseServerImp();
    }

    @Override
    public LowerCaseServer getLowerCaseServer()  {
        return new LowerCaseServerImp();
    }
}
