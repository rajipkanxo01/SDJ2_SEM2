package singletonMultiton;

import java.util.HashMap;
import java.util.Map;

public class Valuable {
    private static Map<String, Valuable> allInstances = new HashMap<>();

    private Valuable() {
    }

    public static Valuable getValuable(String key) {
        Valuable instance = allInstances.get(key);
        if (instance == null) {
            synchronized (allInstances) {
                if (instance == null) {
                    instance = new Valuable();
                    allInstances.put(key, instance);
                }
            }
        }
        return instance;
    }

    public int getValue() {
        if (allInstances.get("Diamond") == this) {
            return 30;
        } else if (allInstances.get("GoldNugget") == this) {
            return 20;
        } else if (allInstances.get("Jewel") == this) {
            return 15;
        } else if (allInstances.get("Ruby") == this) {
            return 10;
        } else if (allInstances.get("Wooden Coin") == this) {
            return 5;
        }
        return -1;
    }


}


