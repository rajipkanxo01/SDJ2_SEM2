package chatExampleMulti.server;

import chatExampleMulti.shared.Message;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private List<ServerSocketHandler> connections = new ArrayList<>();


    public void addConnections (ServerSocketHandler socketHandler) {
        connections.add(socketHandler);
    }

    public void  broadcast (Message msg) {
        for (ServerSocketHandler connection : connections) {
            if (!connection.getClientName().equals(msg.getUser())) {
                connection.sendMessageToClient(msg);
            }
        }
    }

    public void removeConnection(ServerSocketHandler socketHandler) {
        connections.remove(socketHandler);
    }
}
