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
//        if (value > max) {
//            value++;
//            Thread.currentThread().setName("Increment");
//            System.out.println(value + ": " + Thread.currentThread().getName());
//        }
    }

    public synchronized void decrement() throws InterruptedException {
        while (value <= min) {
            wait();
        }
        value--;
        notifyAll();
//        if (value < min) {
//            value--;
//            Thread.currentThread().setName("Decrement");
//            System.out.println(value + ": " + Thread.currentThread().getName());
//        }
    }

    public long getValue() {
        return value;
    }
}
