package stringsQueueBasedOnList;

import java.util.ArrayList;

public class Queue implements StringQueue {

    private int capacity;
    private ArrayList<String> list;

    public Queue(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<>(capacity);
    }

    @Override
    public void enqueue(String element) {
        if (list.size() == capacity) {
            throw new IllegalStateException();
        }

        if (element == null) {
            throw new IllegalArgumentException();
        }

        list.add(element);

    }

    @Override
    public String dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException();
        }

        return list.remove(0);
    }

    @Override
    public String first() {
        try {
            return list.get(0);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int indexOf(String element) {
        if (list.contains(element)) return list.indexOf(element);
        return -1;
    }

    @Override
    public boolean contains(String element) {
        return list.contains(element);
    }

    @Override
    public String toString() {
        return "Queue{" +
                "capacity=" + capacity +
                ", list=" + list +
                '}';
    }
}
