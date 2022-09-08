package counter;

import java.util.concurrent.locks.Lock;

public class CounterIncrement implements Runnable {
    private Counter counter;


    public CounterIncrement(Counter counter) {
        this.counter = counter;
    }

    @Override

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.updateA();
            counter.updateB();
        }

        System.out.println(counter.getCountA());
        System.out.println(counter.getCountB());
    }
}
