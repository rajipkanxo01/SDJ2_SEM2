package taskList.view.next;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import taskList.model.Task;
import taskList.model.TaskModel;

public class NextTaskViewModel {
    private StringProperty description;
    private StringProperty creator;
    private StringProperty date;

    private TaskModel model;

    public NextTaskViewModel(TaskModel model) {
        this.model = model;
        description = new SimpleStringProperty();
        creator = new SimpleStringProperty();
        date = new SimpleStringProperty();
    }

    public void getTask() {
        Task task = model.getTask();
        description.setValue(task.getDescription());
        creator.setValue(task.getOwner());
        date.setValue(task.getTimeCreated());
    }

    public void clear() {
        description.setValue("");
        creator.setValue("");
        date.setValue("");
    }

    public StringProperty descriptionProperty() {
        return description;
    }


    public StringProperty creatorProperty() {
        return creator;
    }


    public StringProperty dateProperty() {
        return date;
    }
}
