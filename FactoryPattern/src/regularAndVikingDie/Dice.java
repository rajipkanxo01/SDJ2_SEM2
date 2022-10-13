package regularAndVikingDie;

public class Dice {
    private boolean isSixSidesDice = true;
    private Factory factory = new RegularDieFactory();

    public void changeDice() {
        if (isSixSidesDice) {
            System.out.println("\n Let's play regular dice");
            factory = new RegularDieFactory();
            isSixSidesDice = false;
        } else {
            System.out.println("\n Let's play viking dice");
            factory = new VikingDieFactory();
            isSixSidesDice = true;
        }
    }

    public void startDie() {
        Die die = factory.startDie();
    }

    public Dice () {

        changeDice();
        startDie();
        startDie();
        startDie();
        startDie();

        changeDice();
        startDie();
        startDie();
        startDie();
        startDie();
        startDie();

        changeDice();
        startDie();
        startDie();
        startDie();
        startDie();
        startDie();
        startDie();
    }
}
