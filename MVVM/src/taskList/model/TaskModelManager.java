package taskList.model;

import javax.xml.crypto.Data;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskModelManager implements TaskModel {
    private List<Task> tasks = new ArrayList<>();
    private PropertyChangeSupport taskSupport = new PropertyChangeSupport(this);

    @Override
    public void addTask(String owner, String description) {
        Task task = new Task(owner, description, calcTimeStamp());
        tasks.add(task);
        taskSupport.firePropertyChange("TaskAdded", null, task);
    }

    private String calcTimeStamp() {
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date now = new Date();
        return date.format(now);
    }

    @Override
    public Task getTask() {
        Task nextTask = tasks.remove(0);
        taskSupport.firePropertyChange("NextTask", null, nextTask);
        return nextTask;
    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        if (eventName == null) {
            taskSupport.addPropertyChangeListener(listener);
        } else {
            taskSupport.addPropertyChangeListener(eventName, listener);
        }
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        taskSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        if (eventName == null) {
            taskSupport.removePropertyChangeListener(listener);
        } else {
            taskSupport.removePropertyChangeListener(eventName, listener);
        }
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        taskSupport.removePropertyChangeListener(listener);
    }
}
