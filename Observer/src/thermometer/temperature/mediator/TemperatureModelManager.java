package thermometer.temperature.mediator;


import thermometer.temperature.model.Temperature;
import thermometer.temperature.model.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel {
    private TemperatureList temperatureList;
    private PropertyChangeSupport support;

    public TemperatureModelManager() {
        temperatureList = new TemperatureList();
        support = new PropertyChangeSupport(this);

    }

    @Override
    public void addTemperature(String id, double value) {
        Temperature temperature = new Temperature(id, value);
        Temperature old = getLastInsertedTemperature();
        this.temperatureList.addTemperature(temperature);
        if (old != null && old.getValue() != temperature.getValue()) {
            System.out.println("-->" + temperature + " (from: " + old + ")");
        }
        support.firePropertyChange("valueChanged", old, temperature);
    }

    @Override
    public Temperature getLastInsertedTemperature() {
        return temperatureList.getLastTemperature(null);
    }

    @Override
    public Temperature getLastInsertedTemperature(String id) {
        return temperatureList.getLastTemperature(id);
    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        if (eventName == null) {
            support.addPropertyChangeListener(listener);
        } else {
            support.addPropertyChangeListener(eventName, listener);
        }
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        if (eventName == null) {
            support.removePropertyChangeListener(listener);
        } else {
            support.removePropertyChangeListener(eventName, listener);
        }
    }

    // and maybe other methods...
}
