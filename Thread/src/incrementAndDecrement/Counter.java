package incrementAndDecrement;

public class Counter {
    private long value;
    private long max;
    private long min;

    public Counter(long max, long min) {
        value = 0;
        this.max = max;
        this.min = min;
    }

    public synchronized void increment() throws InterruptedException {
        while (value >= max) {
            wait();
        }
        value++;
        notifyAll();

    }

    public synchronized void decrement() throws InterruptedException {
        while (value <= min) {
            wait();
        }
        value--;
        notifyAll();

    }

    public long getValue() {
        return value;
    }
}
