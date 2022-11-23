package multipleBridges.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IToRandomCase extends Remote {
    String toRandomCase (String string) throws RemoteException;
}
