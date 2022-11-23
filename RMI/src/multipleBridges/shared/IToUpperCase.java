package multipleBridges.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IToUpperCase extends Remote {
    String toUpperCase(String str) throws RemoteException;
}
