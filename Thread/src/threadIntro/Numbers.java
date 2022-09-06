package threadIntro;

public class Numbers implements  Runnable{
    private int count;

    public Numbers(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(i);
        }
    }
}
