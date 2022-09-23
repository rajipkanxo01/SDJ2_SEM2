package taskList.core;

import taskList.view.add.AddTaskViewModel;
import taskList.view.all.AllTaskViewModel;
import taskList.view.next.NextTaskViewModel;

public class ViewModelFactory {
    private AddTaskViewModel addTaskViewModel;
    private AllTaskViewModel allTaskViewModel;
    private NextTaskViewModel nextTaskViewModel;
    private ModelFactory modelFactory;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public AddTaskViewModel getAddTaskViewModel() {
        if (addTaskViewModel == null) {
            addTaskViewModel = new AddTaskViewModel(modelFactory.getTaskModel());
        }
        return addTaskViewModel;
    }

    public AllTaskViewModel getAllTaskViewModel() {
        if (allTaskViewModel == null) {
            allTaskViewModel = new AllTaskViewModel(modelFactory.getTaskModel());
        }
        return allTaskViewModel;
    }

    public NextTaskViewModel getNextTaskViewModel() {
        if (nextTaskViewModel == null) {
            nextTaskViewModel = new NextTaskViewModel(modelFactory.getTaskModel());
        }
        return nextTaskViewModel;
    }
}
