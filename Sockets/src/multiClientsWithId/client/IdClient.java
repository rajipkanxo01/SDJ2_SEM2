package multiClientsWithId.client;

import java.io.IOException;
import java.net.Socket;

public class IdClient {

    public void startClient() {
        try {
            Socket socket = new Socket("localhost", 2002);
            System.out.println("Client connected!");

            ClientSocketHandler csh = new ClientSocketHandler(socket);
            Thread thread = new Thread(csh);
            thread.start();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
