package multipleBridges.server;

import multipleBridges.shared.IToRandomCase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ToRandomCase implements IToRandomCase {

    public ToRandomCase() {
        try {
            // exporting so server is available remotely
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toRandomCase(String string) {
        String result = "";
        char[] charArray = string.toCharArray();
        for (char c : charArray) {
            result += Math.random() < 0.5 ? (c + "").toUpperCase() : (c + "").toLowerCase();
        }
        return result;
    }
}
