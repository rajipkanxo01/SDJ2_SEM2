package producerConsumer;

import singletonMultiton.Valuable;

import java.util.Random;

public class Mine {
    private static Valuable valuable;
    private static Random random;

    public Mine() {
        random = new Random();
    }

    public Valuable mineValuable() {
        int value = random.nextInt(0, 75);
        if (value <= 5) {
            return Valuable.getValuable("Diamond");
        } else if (value <= 15) {
            return Valuable.getValuable("GoldNugget");
        } else if (value <= 30) {
            return Valuable.getValuable("Jewel");
        } else if (value <= 50) {
            return Valuable.getValuable("Ruby");
        } else if (value <= 75) {
            return Valuable.getValuable("Wooden Coin");
        }
        return null;
    }

}
