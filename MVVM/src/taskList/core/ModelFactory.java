package taskList.core;

import taskList.model.TaskModel;
import taskList.model.TaskModelManager;

public class ModelFactory {
    private TaskModel taskModelManager;

    public TaskModel getTaskModel() {
        // lazy instantiation to only create something when we actually need it
        if (taskModelManager == null) {
            taskModelManager = new TaskModelManager();
        }
        return taskModelManager;
    }
}
