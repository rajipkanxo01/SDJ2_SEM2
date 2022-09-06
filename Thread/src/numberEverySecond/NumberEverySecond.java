package numberEverySecond;

public class NumberEverySecond implements Runnable {
    private int seconds;

    public NumberEverySecond(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(i);
                Thread.sleep(seconds* 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
