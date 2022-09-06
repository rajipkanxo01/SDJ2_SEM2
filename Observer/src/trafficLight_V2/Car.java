package trafficLight_V2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Car implements PropertyChangeListener {
    private String id;

    public Car(String id) {
        this.id = id;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String previousLight = (String) evt.getOldValue();
        String currentLight = (String) evt.getNewValue();

        if ("GREEN".equalsIgnoreCase(currentLight)) {
            System.out.println("Car " + id + " drives");
        } else if ("YELLOW".equalsIgnoreCase(currentLight)) {
            if ("RED".equals(previousLight)) {
                System.out.println("Car " + id + " turns engine on");
            } else {
                System.out.println("Car " + id + " slows down");
            }
        } else if ("RED".equalsIgnoreCase(currentLight)) {
            System.out.println("Car " + id + " stops");
        }
    }
}
