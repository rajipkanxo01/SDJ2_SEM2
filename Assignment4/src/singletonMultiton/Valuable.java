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




}


