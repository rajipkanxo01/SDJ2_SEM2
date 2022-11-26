package adapter;

import singletonMultiton.Log;
import singletonMultiton.Valuable;
import utility.collection.ListADT;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Deposit implements ListADT<Valuable> {
    private int capacity;
    private BlockingQueue<Valuable> queue;
    private Log log;

    public Deposit(int capacity) {
        this.capacity = capacity;

        queue = new ArrayBlockingQueue<>(capacity);
        log = Log.getInstance();
    }


    @Override
    public void add(int index, Valuable element) {

    }

    @Override
    public synchronized void add(Valuable element) {
        while (queue.size() >= capacity) {
            try {
                log.printLog("Can't add more than max capacity");
                log.printLog("Waiting to valuable transporter to remove valuable");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.add(element);
        notifyAll();
    }

    @Override
    public void set(int index, Valuable element) {

    }

    @Override
    public synchronized Valuable get(int index) {
        while (queue.isEmpty()) {
            try {
                log.printLog("No Valuables in Deposit!!!!");
                log.printLog("Waiting for miner to put valuables!");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            notifyAll();
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Valuable remove(int index) {
        return null;
    }

    @Override
    public Valuable remove(Valuable element) {
        return null;
    }

    @Override
    public int indexOf(Valuable element) {
        return 0;
    }

    @Override
    public boolean contains(Valuable element) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
