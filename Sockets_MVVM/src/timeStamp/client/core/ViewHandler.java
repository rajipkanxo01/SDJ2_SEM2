package timeStamp.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import timeStamp.view.TimestampController;

import java.io.IOException;


public class ViewHandler {

    private Stage stage;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
    }

    public void start() throws Exception{
        openView();
    }

    public void openView() {
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        // loads the fxml file
        Parent root = loadFXMLFiles("../view/TimestampView.fxml", loader);
        // this gets controller class specified in loaded fxml file
        TimestampController controller = loader.getController();
        // initializing the controller
        controller.init(viewModelFactory.getTimestampViewModel());
        scene = new Scene(root);

        stage.setTitle("Timestamp View");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        // setting the scene, changing scene to all task view scene

    }


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
