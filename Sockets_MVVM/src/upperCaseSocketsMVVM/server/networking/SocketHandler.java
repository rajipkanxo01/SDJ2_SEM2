package upperCaseSocketsMVVM.server.networking;


import upperCaseSocketsMVVM.server.model.TextManager;
import upperCaseSocketsMVVM.shared.transferobjects.LogEntry;
import upperCaseSocketsMVVM.shared.transferobjects.Request;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketHandler implements Runnable {

    private Socket socket;
    private TextManager textManager;

    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;

    public SocketHandler(Socket socket, TextManager textManager) {
        this.socket = socket;
        this.textManager = textManager;

        try {
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Request request = (Request) inFromClient.readObject();
            switch (request.getType()) {
                case "Listener" -> textManager.addListener("NewLogEntry", this::onNewLogEntry);
                case "Uppercase" -> {
                    String result = textManager.toUppercase((String) request.getArg());
                    outToClient.writeObject(new Request("Uppercase", result));
                }
                case "FetchLog" -> {
                    List<LogEntry> log = textManager.getLog();
                    outToClient.writeObject(new Request("FetchLog", log));
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void onNewLogEntry(PropertyChangeEvent evt) {
        try {
            outToClient.writeObject(new Request(evt.getPropertyName(), evt.getNewValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
