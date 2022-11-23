package stringsQueueBasedOnList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue queue;
    private int capacity;

    @Before
    public void setUp() throws Exception {
        int capacity = 2;
       queue = new Queue(capacity);
    }

    @Test (expected =  IllegalStateException.class)
    public void maxCapacityEnqueue() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
    }

    @Test (expected =  IllegalArgumentException.class)
    public void enqueueNull() {
        queue.enqueue(null);
    }

    @Test
    public void dequeueSuccess() {
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals("B",queue.dequeue());
    }

    @Test (expected = IllegalStateException.class)
    public void dequeueException() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

    }

    @Test (expected =  IllegalStateException.class)
    public void firstEmptyQueue() {
        queue.first();
    }

    @Test
    public void firstSuccess() {
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals("A",queue.first());
    }



    @Test
    public void isEmptyTrue() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void isEmptyFalse() {
        queue.enqueue("A");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void indexOfElementFound() {
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals(1,queue.indexOf("B"));
    }

    @Test
    public void indexOfElementNotFound() {
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals(-1,queue.indexOf("C"));
    }

    @Test
    public void containsElement() {
        queue.enqueue("A");
        queue.enqueue("B");
        assertTrue(queue.contains("A"));
    }

    @Test
    public void containsNotElement() {
        queue.enqueue("A");
        queue.enqueue("B");
        assertFalse(queue.contains("C"));
    }
}