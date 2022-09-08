package rabbitAndTurtle;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        Point point = new Point();
        Turtle turtle = new Turtle(point);
        Thread turtleThread = new Thread(turtle);
        Thread rabbitThread = new Thread(new Rabbit(point, turtle));

        turtleThread.start();
        rabbitThread.start();
        point.check();
    }
}
