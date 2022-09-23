package taskList;

import javafx.application.Application;
import javafx.stage.Stage;
import taskList.core.ModelFactory;
import taskList.core.ViewHandler;
import taskList.core.ViewModelFactory;
import taskList.model.Task;
import taskList.model.TaskModelManager;

public class TaskListApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();

//        Thread thread = new Thread(
//                () -> {
//                    TaskModelManager taskModel = (TaskModelManager) mf.getTaskModel();
//                    for (int i = 0; i < 10; i++) {
//                        try {
//                            Thread.sleep(2500);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//
//                        taskModel.addTask("MyName", "Test task " + i);
//                        System.out.println(i);
//
//                    }
//                });
//        thread.setDaemon(true);
//        thread.start();
    }
}


