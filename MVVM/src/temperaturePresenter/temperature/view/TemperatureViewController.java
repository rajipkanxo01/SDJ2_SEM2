package temperaturePresenter.temperature.view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import temperaturePresenter.temperature.mediator.PropertyChangeSubject;
import temperaturePresenter.temperature.mediator.TemperatureModel;
import temperaturePresenter.temperature.model.Temperature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class TemperatureViewController implements PropertyChangeListener {
    @FXML
    private Label outputLabel;
    @FXML
    private TextField filterField;
    @FXML
    private Label filterLabel;


    private ViewHandler viewHandler;
    private TemperatureModel model;
    private Region root;
    private String thermometerId;


    public TemperatureViewController() {

    }


    public void init(ViewHandler viewHandler, TemperatureModel model, Region root) {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
        thermometerId = null;
        model.addPropertyChangeListener("temperatureAdd",this);
    }

    public void reset() {
        // empty
    }

    public Region getRoot() {
        return root;
    }

    @FXML
    private void updateButtonPressed() {
        if (thermometerId == null) {
            Temperature t1 = model.getLastInsertedTemperature("01");
            Temperature t2 = model.getLastInsertedTemperature("11");
            outputLabel.setText(t2.toString() + "\n" + t1.toString());
        } else if (thermometerId.equals("01")) {
            outputLabel.setText(model.getLastInsertedTemperature("01").toString());
        } else if (thermometerId.equals("11")) {
            outputLabel.setText(model.getLastInsertedTemperature("11").toString());
        }
    }

    @FXML
    private void onFilter() {
        thermometerId = filterField.getText();
        if (thermometerId == null || thermometerId.equals("")) {
            updateButtonPressed();
            filterLabel.setText("All");
        } else {
            filterLabel.setText(thermometerId);
            updateButtonPressed();
        }
        filterField.setText(null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Temperature t1 = (Temperature) evt.getNewValue();
        Temperature t2 = (Temperature) evt.getOldValue();

        Platform.runLater(() -> outputLabel.setText(t1.toString() + "\n" + t2.toString()));
    }
}
