package taskList.view.add;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import taskList.core.ViewHandler;

public class AddTaskViewController {
    @FXML
    private TextField creatorTextField;
    @FXML
    private TextArea descriptionTextArea;

    private ViewHandler viewHandler;
    private AddTaskViewModel viewModel;

    public void init(AddTaskViewModel viewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;

        // bindDirectional so user input is sent to VM and VM can clear the data
        creatorTextField.textProperty().bindBidirectional(viewModel.ownerProperty());
        descriptionTextArea.textProperty().bindBidirectional(viewModel.descriptionProperty());
    }

    @FXML
    private void addButton(ActionEvent actionEvent) {
        viewModel.addNewTask();
        viewModel.clear();
    }

    @FXML
    private void backButton(ActionEvent actionEvent) {
        viewModel.clear();
        viewHandler.openAllTasksView();
    }
}
