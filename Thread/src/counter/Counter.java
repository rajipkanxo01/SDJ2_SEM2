package counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int countA;
    private int countB;

    private Lock LockA = new ReentrantLock();
    private Lock LockB = new ReentrantLock();

    public Counter() {
        countA = 0;
        countB = 0;
    }

    public void updateA() {
        synchronized (LockA) {
            countA++;
        }
    }

    public void updateB() {
        synchronized (LockB) {
            countB++;
        }
    }

    public int getCountA() {
        synchronized (LockA) {
            return countA;
        }
    }

    public int getCountB() {
        synchronized (LockB) {
            return countB;
        }
    }
}
