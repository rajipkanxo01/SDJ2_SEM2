package temperaturePresenter;

import javafx.application.Application;
import javafx.stage.Stage;
import temperaturePresenter.external.Thermometer;
import temperaturePresenter.temperature.mediator.TemperatureModel;
import temperaturePresenter.temperature.mediator.TemperatureModelManager;
import temperaturePresenter.temperature.view.ViewHandler;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    TemperatureModel model = new TemperatureModelManager();
    Thermometer t1 = new Thermometer(model,10,"01",2);
    Thermometer t2 = new Thermometer(model,20,"11",5);

    Thread thread1 = new Thread(t1);
    Thread thread2 = new Thread(t2);

    thread1.start();
    thread2.start();

    // View
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}
