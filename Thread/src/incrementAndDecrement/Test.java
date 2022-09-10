package incrementAndDecrement;

public class Test {
    public static void main(String[] args) {
        Counter counter = new Counter(100, 0);
        CounterIncrementer counterIncrementer1 = new CounterIncrementer(counter, 200);
        CounterIncrementer counterIncrementer2 = new CounterIncrementer(counter, 200);
        CounterDecrementer counterDecrementer1 = new CounterDecrementer(counter, 200);
        CounterDecrementer counterDecrementer2 = new CounterDecrementer(counter, 200);
        Thread ci1Thread = new Thread(counterIncrementer1);
        Thread ci2Thread = new Thread(counterIncrementer2);
        Thread cd1Thread = new Thread(counterDecrementer1);
        Thread cd2Thread = new Thread(counterDecrementer2);
        ci1Thread.start();
        ci2Thread.start();
        cd1Thread.start();
        cd2Thread.start();

    }
}
