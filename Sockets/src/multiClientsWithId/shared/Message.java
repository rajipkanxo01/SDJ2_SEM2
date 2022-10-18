package multiClientsWithId.shared;

import java.io.Serializable;

public class Message implements Serializable {
    private String messageBody;
    private int id;

    public Message(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + ": " + messageBody;
    }
}
