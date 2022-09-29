package temperaturePresenter.core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import temperaturePresenter.mediator.TemperatureModel;
import temperaturePresenter.view.temperature.TemperatureViewController;

import java.io.IOException;

public class ViewHandler {
    private ViewModelFactory viewModelFactory;
    private Stage primaryStage;
    private Scene currentScene;
    private TemperatureModel model;

    public ViewHandler(ViewModelFactory modelFactory) {
        this.viewModelFactory = modelFactory;
    }

    public void start() {
        primaryStage = new Stage();
        openView();
    }

    private void openView() {
        FXMLLoader loader = new FXMLLoader();

        Parent root = loadFXMLFiles("../view/temperature/TemperatureView.fxml", loader);
        TemperatureViewController controller = loader.getController();
        controller.init( viewModelFactory.getTemperatureViewModel());
        currentScene = new Scene(root);

        primaryStage.setScene(currentScene);
        primaryStage.setTitle("Temperature Presenter");
        primaryStage.show();
    }


    private Parent loadFXMLFiles(String path, FXMLLoader loader) {
        loader.setLocation(getClass().getResource(path));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return root;
    }
}
