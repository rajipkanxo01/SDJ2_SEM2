package counter;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Counter count = new Counter();
        Thread counterThread = new Thread(new CounterIncrement(count));
        Thread counterThread2 = new Thread(new CounterIncrement(count));

        counterThread.start();

        counterThread.join();
        counterThread2.start();


    }
}
