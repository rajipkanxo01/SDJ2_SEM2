package temperaturePresenter.core;

import temperaturePresenter.mediator.TemperatureModel;
import temperaturePresenter.mediator.TemperatureModelManager;

public class ModelFactory {
    private TemperatureModel model;

    public TemperatureModel getTemperatureModel() {
        if (model == null) {
            model = new TemperatureModelManager();
        }
        return model;
    }
}
