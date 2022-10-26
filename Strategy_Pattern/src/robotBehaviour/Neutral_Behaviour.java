package robotBehaviour;

import java.awt.geom.Point2D;

public class Neutral_Behaviour implements Behaviour{
    @Override
    public int moveCommand(GameBoard gameBoard, Point2D robotLocation) {
        System.out.println("Neutral Behaviour");
        return 0;
    }
}
