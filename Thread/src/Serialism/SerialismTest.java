package Serialism;

public class SerialismTest {
    public static void main(String[] args) throws InterruptedException {
        Thread serialism1 = new Thread(new Serialism(0, 25000));
        Thread serialism2 = new Thread(new Serialism(25000, 50000));
        Thread serialism3 = new Thread(new Serialism(50000, 75000));
        Thread serialism4 = new Thread(new Serialism(75000, 100000));

        serialism1.start();
        serialism1.join();
        serialism2.start();
        serialism2.join();
        serialism3.start();
        serialism3.join();
        serialism4.start();
        serialism4.join();
    }
}
