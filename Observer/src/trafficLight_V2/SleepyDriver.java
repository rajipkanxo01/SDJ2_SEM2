package trafficLight_V2;

import java.beans.PropertyChangeEvent;

public class SleepyDriver {
    private String id;

    public SleepyDriver(PropertyChangeSubject subject, String id) {
        this.id = id;
        // when an event with name "GREEN" is fired, reactToGreen method will be called
        subject.addPropertyChangeListener("Green", this::reactToGreen);
        subject.addPropertyChangeListener("Red", this::reactToRed);
        subject.addPropertyChangeListener("Yellow", this::reactToYellow);
    }

    public void reactToGreen(PropertyChangeEvent event) {
        System.out.println("Sleepy Driver " + id + " turns engine on");
        System.out.println("Sleepy Driver " + id + " drives");
    }

    public void reactToRed(PropertyChangeEvent event) {
        System.out.println("Sleepy Driver " + id + " stops");
    }

    public void reactToYellow(PropertyChangeEvent event) {
        if ("RED".equals(event.getOldValue())) {
            System.out.println("Sleepy Driver " + id + " doesn't do anything");
        } else {
            System.out.println("Sleepy Driver " + id + " slows down");
        }
    }
}
