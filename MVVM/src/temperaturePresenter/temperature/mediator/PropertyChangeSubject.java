package temperaturePresenter.temperature.mediator;

import java.beans.PropertyChangeListener;


public interface PropertyChangeSubject {
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener);

    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener);

}
