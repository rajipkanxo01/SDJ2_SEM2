package upperCaseConverter.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import simpleMVVM.model.ModelFactory;
import upperCaseConverter.view.UpperCaseViewController;

import java.io.IOException;

public class ViewHandler {
    private Scene upperCaseScene;
    private Stage stage;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
    }

    public void start() {
        stage = new Stage();
        openToUpperCase();
    }

    public void openToUpperCase() {
        if (upperCaseScene == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../view/UpperCaseView.fxml"));
                Parent root = loader.load();
                UpperCaseViewController upperCaseViewController = loader.getController();
                upperCaseViewController.init(viewModelFactory.getUpperCaseVM());
                stage.setTitle("Upper Case Converter");
                stage.setResizable(false);
                upperCaseScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(upperCaseScene);
        stage.show();
    }


}
