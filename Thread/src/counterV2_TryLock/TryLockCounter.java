package counterV2_TryLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockCounter {
    private int count;
    private Lock lock = new ReentrantLock();

    public void increment() throws InterruptedException {
//        if (lock.tryLock()) {
//            count++;
//            lock.unlock();
//        } else {
//            System.out.println("Lock was in use");
//        }
        while (!lock.tryLock()) {
            Thread.sleep(1);
        }
        count++;
        lock.unlock();
    }

    public synchronized int getCount() {
        return count;
    }
}
