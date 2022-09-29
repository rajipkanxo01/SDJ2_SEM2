package temperaturePresenter.view.temperature;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import temperaturePresenter.mediator.TemperatureModel;
import temperaturePresenter.mediator.TemperatureModelManager;
import temperaturePresenter.model.Temperature;

public class TemperatureViewModel {
    private TemperatureModel model;
    private StringProperty outputLabel;
    private StringProperty filterLabel;
    private StringProperty filterField;

    public TemperatureViewModel(TemperatureModel model) {
        this.model = model;
        filterField = new SimpleStringProperty();
        outputLabel = new SimpleStringProperty();
        filterLabel = new SimpleStringProperty();

    }


    public void updateData() {
        String thermometerId = filterField.getValue();
        Temperature t1 = model.getLastInsertedTemperature();

        Temperature t2 = model.getLastInsertedTemperature();
        if (thermometerId == null) {
            outputLabel.setValue(t2.toString() + "\n" + t1.toString());
        } else if (thermometerId.equals("01")) {
            outputLabel.setValue(model.getLastInsertedTemperature("01").toString());
        } else if (thermometerId.equals("11")) {
            outputLabel.setValue(model.getLastInsertedTemperature("11").toString());
        }

    }

    public void filterId() {
        String thermometerId = filterField.getValue();
        if (thermometerId == null || thermometerId.equals("")) {
            filterLabel.setValue("All");
            updateData();
        } else {
            filterLabel.setValue(thermometerId);
            updateData();
        }
        filterField.setValue(null);
    }

    public StringProperty filterFieldProperty() {
        return filterField;
    }

    public StringProperty outputLabelProperty() {
        return outputLabel;
    }

    public StringProperty filterLabelProperty() {
        return filterLabel;
    }
}
