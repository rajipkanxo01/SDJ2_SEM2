package robotBehaviour;

import java.awt.geom.Point2D;

public class Aggressive_Behaviour implements Behaviour {
    @Override
    public int moveCommand(GameBoard gameBoard, Point2D robotLocation) {
        System.out.println("Aggressive Behaviour");
        return 1;
    }
}
