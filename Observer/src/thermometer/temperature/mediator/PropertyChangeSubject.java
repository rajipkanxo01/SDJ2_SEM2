package thermometer.temperature.mediator;

import java.beans.PropertyChangeListener;


public interface PropertyChangeSubject {
    void addPropertyChangeListener(String eventName, PropertyChangeListener listener);

    void removePropertyChangeListener(String eventName, PropertyChangeListener listener);


}
