package taskList.model;

import taskList.util.PropertyChangeSubject;

public interface TaskModel extends PropertyChangeSubject {
    void addTask (String owner, String description);
    Task getTask();
}
