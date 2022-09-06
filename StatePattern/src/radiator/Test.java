package radiator;

public class Test {
    public static void main(String[] args) {
        Radiator radiator = new Radiator(new OffState());

        radiator.getPower();
        radiator.turnUp();
        radiator.getPower();
        radiator.turnUp();
        radiator.turnUp();
        radiator.getPower();
    }
}
