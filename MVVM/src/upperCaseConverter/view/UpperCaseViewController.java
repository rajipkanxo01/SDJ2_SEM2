package upperCaseConverter.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UpperCaseViewController {
    private UpperCaseViewModel upperCaseVM;
    @FXML
    private TextField requestTextField;
    @FXML
    private TextField replyTextField;
    @FXML
    private Label errorLabel;


    public void onSubmitButton(ActionEvent actionEvent) {
        upperCaseVM.convert();
    }

    public void init(UpperCaseViewModel upperCaseVM) {
        replyTextField.setDisable(true);
        this.upperCaseVM = upperCaseVM;
        requestTextField.textProperty().bindBidirectional(upperCaseVM.requestProperty());
        replyTextField.textProperty().bind(upperCaseVM.replyProperty());
        errorLabel.textProperty().bind(upperCaseVM.errorProperty());
    }
}
