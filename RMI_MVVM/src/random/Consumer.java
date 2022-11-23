package random;

import java.util.List;

public class Consumer implements Runnable {
    private List<Integer> list;
    private int capacity;

    public Consumer(List<Integer> list, int capacity) {
        this.list = list;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    // consumer thread waits while list is empty
                    while (list.size() == 0)
                        wait();


                    int val = list.remove(0);

                    System.out.println("Consumer consumed-"
                            + val);

                    // Wake up producer thread so producer can start adding data into the queue
                    notify();

                    // and sleep
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
