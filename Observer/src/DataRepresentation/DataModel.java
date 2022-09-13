package DataRepresentation;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class DataModel implements PropertyChangeSubject {

    private int red, green, yellow;
    private Random random = new Random();
    private PropertyChangeSupport dateSupport;

    public DataModel() {
        dateSupport = new PropertyChangeSupport(this);
    }

    public void recalculateData() {
        int first = random.nextInt(100) + 1;
        int second = random.nextInt(100) + 1;
        int bottom = Math.min(first, second);
        int top = Math.max(first, second);

        red = bottom;
        green = top - bottom;
        yellow = 100 - top;
        System.out.println("red: " + red);
        System.out.println("green: " + green);
        System.out.println("yellow: " + yellow);
        System.out.println("Sum: " + (red + green + yellow) + "\n");
        dateSupport.firePropertyChange("RedChange", null, red);
        dateSupport.firePropertyChange("GreenChange", null, green);
        dateSupport.firePropertyChange("YellowChange", null, yellow);
    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        dateSupport.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        dateSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        dateSupport.removePropertyChangeListener(eventName, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        dateSupport.removePropertyChangeListener(listener);
    }
}
