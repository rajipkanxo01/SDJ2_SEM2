package birdWatching;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Random;

public class Bird implements PropertyChangeSubject {
    private PropertyChangeSupport support;


    public Bird() {
        support = new PropertyChangeSupport(this);
    }

    public void start() throws InterruptedException {
        ArrayList<String> conditions = new ArrayList<>();
        conditions.add("flashes its wings");
        conditions.add("whistles");
        conditions.add("sings a song");
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int number = random.nextInt(0, 3);
            System.out.println(" \n Peacock " + conditions.get(number));
            support.firePropertyChange(conditions.get(number), null, conditions.get(number));
            Thread.sleep(2000);
        }
    }


    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
