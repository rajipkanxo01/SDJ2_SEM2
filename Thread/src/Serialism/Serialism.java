package Serialism;

public class Serialism implements Runnable {
    private int x;
    private int y;

    public Serialism(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public void run() {
        for (int i = x; i < y; i++) {
            System.out.println(i);
        }

    }
}
