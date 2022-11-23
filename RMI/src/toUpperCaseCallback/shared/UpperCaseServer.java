package toUpperCaseCallback.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UpperCaseServer extends Remote {
    void toUppercase(String str, UpperCaseClient client) throws RemoteException;
}
