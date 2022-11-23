package printMessage.client;


public class ClientMain {
    public static void main(String[] args) {
        TextClient client = new TextClient();
        client.startClient();

        client.sendText("Hello! This is first text");
        client.sendText("This is second text!!!1");
    }
}
