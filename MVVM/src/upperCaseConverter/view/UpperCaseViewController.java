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
        upperCaseVM.chaængeReq();
    }

    public void init(UpperCaseViewModel upperCaseVM) {
        replyTextField.setDisable(true);
        this.upperCaseVM = upperCaseVM;
//        upperCaseVM.requestProperty().bind(requestTextField.textProperty());
        requestTextField.textProperty().bindBidirectional(upperCaseVM.requestProperty());
        replyTextField.textProperty().bind(upperCaseVM.replyProperty());
        errorLabel.textProperty().bind(upperCaseVM.errorProperty());
    }
}
