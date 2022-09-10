package incrementAndDecrement;

public class CounterIncrementer implements Runnable {
    private int updates;
    private Counter counter;

    public CounterIncrementer(Counter counter, int updates) {
        this.counter = counter;
        this.updates = updates;
    }

    @Override
    public void run() {
        for (int i = 0; i < updates; i++) {
            try {
                counter.increment();
                System.out.println(counter.getValue() + ": " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(counter.getValue());
    }
}
