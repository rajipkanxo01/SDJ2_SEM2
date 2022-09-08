package counterV2_TryLock;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        TryLockCounter count = new TryLockCounter();
        Thread counterThread1 = new Thread(new CounterIncrement(count));
        Thread counterThread2 = new Thread(new CounterIncrement(count));

        counterThread1.start();
        counterThread2.start();


    }
}
