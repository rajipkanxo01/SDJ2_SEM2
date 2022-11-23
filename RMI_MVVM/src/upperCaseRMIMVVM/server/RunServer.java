package upperCaseRMIMVVM.server;


import upperCaseRMIMVVM.server.model.TextManagerImpl;
import upperCaseRMIMVVM.server.networking.RMIServerImpl;
import upperCaseRMIMVVM.shared.networking.RMIServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        RMIServer server = new RMIServerImpl(new TextManagerImpl());
        server.startServer();
    }
}
