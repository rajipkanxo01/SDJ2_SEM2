package trafficLight_V2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrafficLight implements PropertyChangeSubject {
    private String[] lights = {"Green", "Yellow", "Red", "Yellow"};
    private int count = 2;
    private String currentLight;
    private PropertyChangeSupport lightSupport;

    public TrafficLight() {
        currentLight = lights[count];
        lightSupport = new PropertyChangeSupport(this); // ask source of subject as  argument
    }

    public void start() throws InterruptedException {
        String previous = "";
        for (int i = 0; i < 10; i++) {
            Thread.sleep(2000);
            count = (++count) % 4;
            previous = currentLight;
            currentLight = lights[count];
            System.out.println("\nLight is " + currentLight);

            // when currentLight event is fired, Sleepy Driver will react to that
            lightSupport.firePropertyChange(currentLight, previous, currentLight);
        }

    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        lightSupport.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        lightSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        lightSupport.removePropertyChangeListener(eventName, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        lightSupport.removePropertyChangeListener(listener);
    }
}
