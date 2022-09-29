package temperaturePresenter.view.temperature;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import temperaturePresenter.core.ViewHandler;
import temperaturePresenter.mediator.TemperatureModel;
import temperaturePresenter.model.Temperature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class TemperatureViewController  {
    @FXML
    private Label outputLabel;
    @FXML
    private TextField filterField;
    @FXML
    private Label filterLabel;


    private ViewHandler viewHandler;
    private TemperatureModel model;

    private String thermometerId;
    private TemperatureViewModel temperatureViewModel;


    public TemperatureViewController() {

    }


    public void init( TemperatureViewModel temperatureViewModel) {
        this.temperatureViewModel = temperatureViewModel;
        outputLabel.textProperty().bind(temperatureViewModel.outputLabelProperty());
        filterField.textProperty().bindBidirectional(temperatureViewModel.filterFieldProperty());
        filterLabel.textProperty().bind(temperatureViewModel.filterLabelProperty());
//        model.addPropertyChangeListener("temperatureAdd", this);
    }

    @FXML
    private void updateButtonPressed() {
        temperatureViewModel.updateData();
    }

    @FXML
    private void onFilter() {
        temperatureViewModel.filterId();
    }

//    @Override
//    public void propertyChange(PropertyChangeEvent evt) {
//        Temperature t1 = (Temperature) evt.getNewValue();
//        Temperature t2 = (Temperature) evt.getOldValue();
//
//        Platform.runLater(() -> outputLabel.setText(t1.toString() + "\n" + t2.toString()));
//    }
}
