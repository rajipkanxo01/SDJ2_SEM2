package toUpperCase.server;

import toUpperCase.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

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
    public String toUppercase(String str){
        String result = str.toUpperCase();
        return result;
    }



}
