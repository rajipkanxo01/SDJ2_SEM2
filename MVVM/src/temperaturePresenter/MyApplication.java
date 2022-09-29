package temperaturePresenter;

import javafx.application.Application;
import javafx.stage.Stage;
import temperaturePresenter.core.ModelFactory;
import temperaturePresenter.core.ViewModelFactory;
import temperaturePresenter.external.Thermometer;
import temperaturePresenter.mediator.TemperatureModel;
import temperaturePresenter.mediator.TemperatureModelManager;
import temperaturePresenter.core.ViewHandler;

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
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start();
  }
}
