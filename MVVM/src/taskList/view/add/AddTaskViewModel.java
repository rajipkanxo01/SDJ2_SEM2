package taskList.view.add;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import taskList.model.TaskModel;
import taskList.util.ShowAlert;

public class AddTaskViewModel {
    private StringProperty owner;
    private StringProperty description;
    private TaskModel model;
    private ShowAlert alert;

    public AddTaskViewModel(TaskModel model) {
        this.model = model;
        alert = new ShowAlert();
        owner = new SimpleStringProperty();
        description = new SimpleStringProperty();
    }


    public StringProperty descriptionProperty() {
        return description;
    }

    public StringProperty ownerProperty() {
        return owner;
    }

    public void addNewTask() {
        if (!owner.getValue().equals("") || !description.getValue().equals("")) {
            model.addTask(owner.getValue(), description.getValue());
            alert.showConfirmation("Task is added!");
            clear();
        } else {
            alert.showError("Empty Fields!");
        }
    }

    public void clear() {
        description.setValue(null);
        owner.setValue(null);
    }
}
