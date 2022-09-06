package bearAndMan;

public class Bear implements Runnable {


    @Override
    public void run() {
        System.out.println("Bear is feeling tired");
        System.out.println("Bear goes to sleep");

        Thread bear2 = new Thread(new Bear());
        Thread bear3 = new Thread(new Bear());
        Thread bear4 = new Thread(new Bear());
        Thread bear5 = new Thread(new Bear());

        try {
            Thread.sleep(10000);
            System.out.println("Happy Bear");
        } catch (InterruptedException e) {
            System.out.println("Angry Bear!!!!!");
//            bear2.interrupt();
            System.out.println("First Bear Wakes Up Second Bear!");
//            bear3.interrupt();
            System.out.println("First Bear Wakes Up Third Bear!");
//            bear4.interrupt();
            System.out.println("First Bear Wakes Up Fourth Bear!");
//            bear5.interrupt();
            System.out.println("First Bear Wakes Up Fifth Bear!");
        }
    }
}
