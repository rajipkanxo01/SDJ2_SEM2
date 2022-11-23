package upperCaseRMIMVVM.client.core;


import upperCaseRMIMVVM.client.network.Client;
import upperCaseRMIMVVM.client.network.RMIClient;

public class ClientFactory {

    private Client client;

    public Client getClient() {
        if (client == null) {
            client = new RMIClient();
        }
        return client;
    }
}

