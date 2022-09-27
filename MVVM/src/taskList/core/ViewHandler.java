package taskList.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import taskList.view.add.AddTaskViewController;
import taskList.view.all.AllTasksViewController;
import taskList.view.next.NextTaskViewController;

import java.io.IOException;
import java.net.URL;

public class ViewHandler {
    // each stage is separate window
    private Stage stage;
    private Scene addTaskViewScene;
    private Scene nextTaskViewScene;
    private Scene allTaskViewScene;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
    }

    public void start() {
        stage = new Stage();
        openAllTasksView();
        stage.show();


    }


    public void openAllTasksView() {
        FXMLLoader loader = new FXMLLoader();
        // loads the fxml file
        Parent root = loadFXMLFiles("../view/all/AllTasksView.fxml", loader);
        // this gets controller class specified in loaded fxml file
        AllTasksViewController controller = loader.getController();
        // initializing the controller
        controller.init(viewModelFactory.getAllTaskViewModel(), this);
        allTaskViewScene = new Scene(root);

        stage.setTitle("View Task");
        stage.setResizable(false);
        stage.setScene(allTaskViewScene);
        // setting the scene, changing scene to all task view scene

    }

    public void openAddTasksView() {
        FXMLLoader loader = new FXMLLoader();

        if (addTaskViewScene == null) {
            Parent root = loadFXMLFiles("../view/add/AddTaskView.fxml", loader);
            AddTaskViewController controller = loader.getController();
            controller.init(viewModelFactory.getAddTaskViewModel(), this);
            addTaskViewScene = new Scene(root);
        }
        stage.setTitle("View Task");
        stage.setResizable(false);
        stage.setScene(addTaskViewScene);
    }

    public void openGetNextTaskView() {
        FXMLLoader loader = new FXMLLoader();

        if (addTaskViewScene == null) {
            Parent root = loadFXMLFiles("../view/next/NextTaskView.fxml", loader);
            NextTaskViewController controller = loader.getController();
            controller.init(viewModelFactory.getNextTaskViewModel(), this);
            nextTaskViewScene = new Scene(root);
        }
        stage.setTitle("View Task");
        stage.setResizable(false);
        stage.setScene(nextTaskViewScene);
    }

    // loader contains the controller
    // this method is used to load fxml files into parent object
    private Parent loadFXMLFiles(String path, FXMLLoader loader) {
        loader.setLocation(getClass().getResource(path));
        Parent root = null;
        try {
            // loading fxml files in parent instance, containing all GUI elements
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

}
