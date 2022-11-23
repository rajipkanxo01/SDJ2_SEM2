package printMessage.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TextServer extends Remote {
    void printText(String string) throws RemoteException;
}
