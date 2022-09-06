package threadIntro;

public class Letters implements Runnable {

    private int count;

    public Letters(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println((char) (i + 97));
        }
    }
}
