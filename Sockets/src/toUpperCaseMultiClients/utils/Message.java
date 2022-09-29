package toUpperCaseMultiClients.utils;

import java.io.Serializable;

public class Message implements Serializable {
    private String messageBody;

    public Message(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getMessageBody() {
        return messageBody;
    }

    @Override
    public String toString() {
        return "messageBody='" + messageBody + '\'';
    }
}
