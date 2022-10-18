package upperCaseSocketsMVVM.client.core;


import upperCaseSocketsMVVM.client.network.Client;
import upperCaseSocketsMVVM.client.network.SocketClient;

public class ClientFactory {

    private Client client;

    public Client getClient() {
        if (client == null) {
            client = new SocketClient();
        }
        return client;
    }
}

