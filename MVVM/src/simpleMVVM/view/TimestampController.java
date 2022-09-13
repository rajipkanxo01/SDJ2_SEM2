package simpleMVVM.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import simpleMVVM.viewmodel.TimestampViewModel;

import java.net.URL;
import java.util.ResourceBundle;
//import viewmodel.ViewModelFactory;

public class TimestampController{

    @FXML
    Label eventLabel;

    @FXML
    Label numberOfUpdates;


    private TimestampViewModel viewModel;

    public TimestampController() {
    }

    public void init(TimestampViewModel viewModel) {
        this.viewModel = viewModel;

        eventLabel.textProperty().bind(viewModel.updateTimeStampProperty());

        numberOfUpdates.textProperty().bind(viewModel.numberOfUpdate());

    }

    public void onUpdateButton(ActionEvent actionEvent) {
        viewModel.updateTimestamp();

    }


}
