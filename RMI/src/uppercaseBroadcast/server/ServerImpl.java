package uppercaseBroadcast.server;

import uppercaseBroadcast.client.RMIClient;
import uppercaseBroadcast.shared.UpperCaseClient;
import uppercaseBroadcast.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements UpperCaseServer {

    private List<UpperCaseClient> clientsForBroadcast;

    public ServerImpl() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        clientsForBroadcast = new ArrayList<>();
    }

    @Override
    public String toUpperCase(String str, UpperCaseClient client) {
        String result = str.toUpperCase();
        updateClients(result, client);

        return result;
    }

    private void updateClients(String result, UpperCaseClient dontBroadcastToMe) {
        for (UpperCaseClient client : clientsForBroadcast) {
            if(client.equals(dontBroadcastToMe)) continue;

            try {
                client.update(result);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void registerClient(UpperCaseClient clientToRegister) {
        clientsForBroadcast.add(clientToRegister);
    }



}
