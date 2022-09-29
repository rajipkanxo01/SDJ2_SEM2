package temperaturePresenter.temperature.mediator;

import temperaturePresenter.temperature.model.Temperature;

public interface TemperatureModel extends PropertyChangeSubject
{
  void addTemperature(String id, double temperature);

  Temperature getLastInsertedTemperature();

  Temperature getLastInsertedTemperature(String id);
}
