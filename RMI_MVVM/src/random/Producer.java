package random;

import java.util.List;

public class Producer implements Runnable {
    private List<Integer> list;
    private int capacity;

    public Producer(List<Integer> list, int capacity) {
        this.list = list;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        int value = 0;
        while (true) {
            synchronized (this) {
                try {
                    // if the list (queue) is full, producer will wait
                    while (list.size() == capacity)
                        wait();

                    System.out.println("Producer produced-"
                            + value);

                    list.add(value++);

                    // when producer adds item to the list (queue) it will notify consumer to start removing data
                    notify();

                    // makes the working of program easier
                    // to  understand
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
