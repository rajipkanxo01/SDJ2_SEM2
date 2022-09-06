package bearAndMan;

public class Man implements Runnable {
    private Thread bearThread1;



    public Man(Thread bearThread1) {
        this.bearThread1 = bearThread1;


    }

    @Override
    public void run() {


        bearThread1.interrupt();
        System.out.println("First bear wakes up");

        try {
            bearThread1.join();
            System.out.println("Man Walking");
            System.out.println("Man sees a bear, wishes to poke a bear");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("RIP");
    }
}
