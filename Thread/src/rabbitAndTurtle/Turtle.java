package rabbitAndTurtle;

public class Turtle implements Runnable {
    private Point point;

    public Turtle(Point point) {
        this.point = point;
    }



    @Override
    public void run() {

        while (!point.isGameOver()) {
            point.increaseTurtle();

            System.out.println("Turtle point :"+point.getTurtlePoint());
            try {
                Thread.sleep(8);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public int getPoint() {
        return point.getTurtlePoint();
    }
}
