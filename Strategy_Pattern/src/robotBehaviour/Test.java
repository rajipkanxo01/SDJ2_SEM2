package robotBehaviour;


public class Test {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        Robot robot = new Robot("panguuu",gameBoard);

        robot.setBehaviourStrategy(new Aggressive_Behaviour());

        robot.move();

    }

}
