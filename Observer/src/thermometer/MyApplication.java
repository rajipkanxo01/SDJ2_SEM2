package thermometer;

import javafx.application.Application;
import javafx.stage.Stage;
import thermometer.external.Thermometer;
import thermometer.temperature.mediator.TemperatureModel;
import thermometer.temperature.mediator.TemperatureModelManager;
import thermometer.temperature.view.ViewHandler;


public class MyApplication extends Application {
    public void start(Stage primaryStage) {
        // Model
        TemperatureModel model = new TemperatureModelManager();

        Thermometer thermometer1 = new Thermometer(15, "01", 5, model);
        Thermometer thermometer2 = new Thermometer(12, "02", 7, model);

        Thread thread1 = new Thread(thermometer1);
        Thread thread2 = new Thread(thermometer2);

        thread1.start();
        thread2.start();

        // View
        ViewHandler view = new ViewHandler(model);
        view.start(primaryStage);
    }
}
