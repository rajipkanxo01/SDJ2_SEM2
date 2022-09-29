package toUpperCaseMultiClients.server;

import toUpperCaseMultiClients.utils.Message;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private List<ServerSocketHandler> handlers = new ArrayList<>();

    public void addClient(ServerSocketHandler socketHandler) {
        handlers.add(socketHandler);
    }

    public void removeClient(ServerSocketHandler socketHandler) {
        if (handlers.contains(socketHandler)) {
            handlers.remove(socketHandler);
        }
    }

    public int getNumberOfClient() {
        return handlers.size();
    }

    public void broadcast(Message message) {
        for (ServerSocketHandler ssh : handlers) {
            ssh.sendMessage(message);
        }
    }
}
