package random;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        Producer producer = new Producer(list, 2);
        Consumer consumer = new Consumer(list, 2);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
