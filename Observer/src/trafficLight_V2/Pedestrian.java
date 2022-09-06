package trafficLight_V2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Pedestrian {
    private String id;

    public Pedestrian(PropertyChangeSubject subject, String id) {
        this.id = id;
        PropertyChangeListener listener = evt -> setLight(evt);
        subject.addPropertyChangeListener(listener);
    }

    public void setLight(PropertyChangeEvent evt) {
        String previousLight = (String) evt.getOldValue();
        String currentLight = (String) evt.getNewValue();
        if ("GREEN".equalsIgnoreCase(currentLight)) {
            System.out.println("Pedestrian " + id + " waits.");
        } else if ("YELLOW".equalsIgnoreCase(currentLight)) {
            if ("RED".equals(previousLight)) {
                System.out.println("Pedestrian " + id + " gets ready to cross.");
            } else {
                System.out.println("Pedestrian " + id + " runs faster across the road.");
            }
        } else if ("RED".equalsIgnoreCase(currentLight)) {
            System.out.println("Pedestrian " + id + " crosses the road.");
        }
    }
}
