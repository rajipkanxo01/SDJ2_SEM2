package counterV2_TryLock;

public class CounterIncrement implements Runnable {
    private TryLockCounter tryLockCounter;


    public CounterIncrement(TryLockCounter tryLockCounter) {
        this.tryLockCounter = tryLockCounter;
    }

    @Override

    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                tryLockCounter.increment();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(tryLockCounter.getCount());
    }
}
