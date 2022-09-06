package numberEverySecond;

public class NumberTest {
    public static void main(String[] args) {
        Thread numberThread = new Thread(new NumberEverySecond(2));

        numberThread.start();
    }
}
