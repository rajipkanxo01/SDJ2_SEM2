package incrementAndDecrement;

public class CounterDecrementer implements Runnable {
    private int updates;
    private Counter counter;

    public CounterDecrementer(Counter counter, int updates) {
        this.counter = counter;
        this.updates = updates;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < updates; i++) {
            try {
                counter.decrement();
                System.out.println(counter.getValue() + ": " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(counter.getValue());
    }
}
