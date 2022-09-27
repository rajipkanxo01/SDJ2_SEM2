package pieChart.view.textChart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TextChartController {
    @FXML
    private Label eventLabel;
    @FXML
    private TextField xTextField;
    @FXML
    private TextField yTextField;
    @FXML
    private TextField zTextField;

    private TextChartViewModel textChartViewModel;


    public void init(TextChartViewModel textChartViewModel) {
        this.textChartViewModel = textChartViewModel;
        xTextField.textProperty().bindBidirectional(textChartViewModel.xProperty());
        yTextField.textProperty().bindBidirectional(textChartViewModel.yProperty());
        zTextField.textProperty().bindBidirectional(textChartViewModel.zProperty());

        eventLabel.textProperty().bind(textChartViewModel.timeStampProperty());
    }

    public void onUpdateButton(ActionEvent actionEvent) {
        textChartViewModel.updateTextFields();
    }

    public void onSaveButton(ActionEvent actionEvent) {
        textChartViewModel.saveChanges();
    }
}
