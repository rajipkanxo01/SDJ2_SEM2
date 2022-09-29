package temperaturePresenter.mediator;


import temperaturePresenter.model.TemperatureList;
import temperaturePresenter.model.Temperature;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel {
    private TemperatureList temperatureList;
    private PropertyChangeSupport support;

    public TemperatureModelManager() {
        support = new PropertyChangeSupport(this);
        temperatureList = new TemperatureList();
    }

    @Override
    public void addTemperature(String id, double value) {
        Temperature temperature = new Temperature(id, value);
        Temperature old = getLastInsertedTemperature();
        this.temperatureList.addTemperature(temperature);
//        support.firePropertyChange("temperatureAdd", old, temperature);
        if (old != null && old.getValue() != temperature.getValue()) {
            System.out.println("-->" + temperature + " (from: " + old + ")");
        }
    }

    @Override
    public Temperature getLastInsertedTemperature() {
        System.out.println(temperatureList.getLastTemperature(null) + "-- Model Manager");
        System.out.println(temperatureList.getSize() + "------------size");
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
        }
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        if (eventName == null) {
            support.removePropertyChangeListener(listener);
        }
        support.removePropertyChangeListener(eventName, listener);
    }
}
