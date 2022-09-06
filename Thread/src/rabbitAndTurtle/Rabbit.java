package rabbitAndTurtle;

import java.util.Random;

public class Rabbit extends Thread {
    private Point point;
    private Turtle turtle;

    public Rabbit(Point point ) {
        this.point = point;
    }

    public void rabbitSleep() {
        while (point.getRabbitPoint() - point.getTurtlePoint() >= 50) {
            Random random = new Random();
            int number = random.nextInt(1000);
            try {
                Thread.sleep(number);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        while(!point.isGameOver()) {
            point.increaseRabbit();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Rabbit : " + point.getRabbitPoint());
            rabbitSleep();
        }
    }
}
