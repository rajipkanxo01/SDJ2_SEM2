package taskList.view.all;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import taskList.core.ViewHandler;
import taskList.model.Task;

public class AllTasksViewController {
    private ViewHandler viewHandler;
    @FXML
    private TableColumn<String, Task> creatorColumn;
    @FXML
    private TableColumn<String, Task> descriptionColumn;
    @FXML
    private TableColumn<String, Task> dateColumn;
    @FXML
    private TableView<Task> taskTableView;

    public void init(AllTaskViewModel allTaskVM, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;

        // property value factory defines which data to show in table
        creatorColumn.setCellValueFactory(new PropertyValueFactory<>("owner"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("timeCreated"));
        // getting the observable list from view model and setting it to table view to display them in table
        // view model holds the data and controller class shows the data
        taskTableView.setItems(allTaskVM.getTasks());
    }

    @FXML
    private void addButtonAll(ActionEvent actionEvent) {
        viewHandler.openAddTasksView();
    }

    @FXML
    private void nextTaskButtonAll(ActionEvent actionEvent) {
        viewHandler.openGetNextTaskView();
    }
}
