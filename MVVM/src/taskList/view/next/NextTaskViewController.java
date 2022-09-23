package taskList.view.next;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import taskList.core.ViewHandler;

public class NextTaskViewController {
    @FXML
    private TextArea nextTaskLabel;
    @FXML
    private Label createdByLabel;
    @FXML
    private Label createdAtLabel;

    private ViewHandler vh;
    private NextTaskViewModel nextTaskViewModel;

    public void init(NextTaskViewModel nextTaskViewModel, ViewHandler vh) {
        this.nextTaskViewModel = nextTaskViewModel;
        this.vh = vh;
        nextTaskLabel.setDisable(true);

        // next task label updates when description property changes
        nextTaskLabel.textProperty().bind(nextTaskViewModel.descriptionProperty());
        createdByLabel.textProperty().bind(nextTaskViewModel.creatorProperty());
        createdAtLabel.textProperty().bind(nextTaskViewModel.dateProperty());
    }

    public void getTaskButton(ActionEvent actionEvent) {
        nextTaskViewModel.getTask();
    }

    public void onBack(ActionEvent actionEvent) {
        nextTaskViewModel.clear();
        vh.openAllTasksView();
    }


}
