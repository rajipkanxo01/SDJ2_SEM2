package rabbitAndTurtle;

public class Point {
    private int rabbitPoint;
    private int turtlePoint;

    private boolean gameOver;
    public Point() {
        this.rabbitPoint = 0;
        this.turtlePoint = 0;
        gameOver = false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void increaseRabbit() {
        rabbitPoint++;
        check();
    }

    public void increaseTurtle() {
        turtlePoint++;
        check();
    }

    public void check() {
        if (rabbitPoint>=1000) {
            gameOver=true;
            System.out.println("Rabbit Wins!, Slow and steady is for books kiddos");
        }
        else if (turtlePoint >= 1000) {
            gameOver=true;
            System.out.println("Turtle Wins!,SLOW AND STEADY ALL THE WAY , you bitch ");
        }
    }

    public int getTurtlePoint() {
        return turtlePoint;
    }

    public int getRabbitPoint() {
        return rabbitPoint;
    }
}
