package counter;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Counter count = new Counter();
        Thread counterThread1 = new Thread(new CounterIncrement(count));
       Thread counterThread2 = new Thread(new CounterIncrement(count));
//       Thread counterThread3 = new Thread(new CounterIncrement(count));

        counterThread1.start();
        counterThread2.start();
//        counterThread3.start();


    }
}
