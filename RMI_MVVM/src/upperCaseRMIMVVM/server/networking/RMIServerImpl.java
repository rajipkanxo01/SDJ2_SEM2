package upperCaseRMIMVVM.server.networking;

import upperCaseRMIMVVM.server.model.TextManager;
import upperCaseRMIMVVM.shared.networking.ClientCallBack;
import upperCaseRMIMVVM.shared.networking.RMIServer;
import upperCaseRMIMVVM.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeEvent;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIServerImpl implements RMIServer {
    private TextManager textManager;

    public RMIServerImpl(TextManager textManager) {
        this.textManager = textManager;
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void startServer() throws RemoteException, AlreadyBoundException {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Server", this);


    }

    @Override
    public String toUpperCase(String str) throws RemoteException {
        return textManager.toUppercase(str);
    }

    @Override
    public List<LogEntry> getLogs() throws RemoteException {
        return textManager.getLog();
    }

    @Override
    public void registerClient(ClientCallBack client) {
        textManager.addListener("NewLogEntry", event -> {
            try {
                client.update((LogEntry) event.getNewValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
    }


}
