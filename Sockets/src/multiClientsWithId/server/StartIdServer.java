package multiClientsWithId.server;

public class StartIdServer {
    public static void main(String[] args) {
        IdServer server = new IdServer();
        server.startServer();
    }
}
