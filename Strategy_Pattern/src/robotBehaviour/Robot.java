package robotBehaviour;

import java.awt.*;

public class Robot {
    private String name;
    private GameBoard gameBoard;
    private Behaviour behaviourStrategy;

    public Robot(String name, GameBoard gameBoard) {
        this.name = name;
        this.gameBoard = gameBoard;
    }

    public Behaviour getBehaviourStrategy() {
        return behaviourStrategy;
    }

    public void setBehaviourStrategy(Behaviour behaviourStrategy) {
        this.behaviourStrategy = behaviourStrategy;
    }

    public void move() {
        Point point = new Point(2, 3);
        behaviourStrategy.moveCommand(gameBoard, point);
        System.out.println(name + "moved to " + point);
    }
}
