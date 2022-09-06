package threadIntro;

public class ThreadRuns {
    public static void main(String[] args) {
        Thread numberThread = new Thread(new Numbers(50));
        Thread lettersThread = new Thread(new Letters(33));

        lettersThread.start();
        numberThread.start();
    }
}
