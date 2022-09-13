package DataRepresentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DataApp extends Application {
    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Data Representation");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("visualData.fxml"));
        Scene scene = new Scene(loader.load());
        window.setScene(scene);
        window.show();
        window.setResizable(false);
    }
}
