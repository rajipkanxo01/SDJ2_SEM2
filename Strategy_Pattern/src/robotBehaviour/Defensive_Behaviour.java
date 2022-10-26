package robotBehaviour;

import java.awt.geom.Point2D;

public class Defensive_Behaviour implements Behaviour{
    @Override
    public int moveCommand(GameBoard gameBoard, Point2D robotLocation) {
        System.out.println("Defensive Behaviour");
        return -1;
    }
}
