package upperCaseSocketsMVVM.server;


import upperCaseSocketsMVVM.server.model.TextManagerImpl;
import upperCaseSocketsMVVM.server.networking.SocketServer;

public class RunServer {
    public static void main(String[] args) {

        SocketServer ss = new SocketServer(new TextManagerImpl());
        ss.startServer();
    }
}
