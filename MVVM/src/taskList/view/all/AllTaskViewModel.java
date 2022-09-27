package taskList.view.all;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import taskList.model.Task;
import taskList.model.TaskModel;

import java.beans.PropertyChangeEvent;

public class AllTaskViewModel {
    private ObservableList<Task> tasks;
    private TaskModel model;

    public AllTaskViewModel(TaskModel model1) {
        this.model = model1;
        tasks = FXCollections.observableArrayList();
        // when task added event is fired from task model manager (subject), addTaskToList method is called
        model.addPropertyChangeListener("TaskAdded", this::addTaskToList);
        // when next task event is fired from task model manager (subject),getNextTask method is called
        model.addPropertyChangeListener("NextTask", this::getNextTask);
    }

    private void getNextTask(PropertyChangeEvent event) {
        // gets task as new value from fired event from list  in model manager and removes it from observable array list
        tasks.remove((Task) event.getNewValue());
    }


    private void addTaskToList(PropertyChangeEvent event) {
        // gets task as new value from fired event and adds it to observable array list
        tasks.add((Task) event.getNewValue());
    }

    // to display task in tableview from controller which can retrieve the list
    public ObservableList<Task> getTasks() {
        System.out.println(tasks.size());
        return tasks;
    }
}
