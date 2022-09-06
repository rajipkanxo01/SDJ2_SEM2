package counter;

public class CounterIncrement implements Runnable {
    private Counter counter;


    public CounterIncrement(Counter counter) {
        this.counter = counter;
    }

    @Override
    // Incrementing the counter by 1 million times.
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            counter.update();
        }

        System.out.println(counter.getCount());
        if (counter.getCount()==1000000) {
            System.out.println("Verified");
        }
    }
}
