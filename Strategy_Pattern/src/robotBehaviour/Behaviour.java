package robotBehaviour;

import java.awt.geom.Point2D;

public interface Behaviour {
    int moveCommand(GameBoard gameBoard, Point2D  robotLocation);
}
