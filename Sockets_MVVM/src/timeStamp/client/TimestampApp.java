package timeStamp;

import javafx.application.Application;
import javafx.stage.Stage;
import timeStamp.core.ModelFactory;
import timeStamp.core.ViewHandler;
import timeStamp.core.ViewModelFactory;


@SuppressWarnings("ALL")
public class TimestampApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(mf);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
        viewHandler.start();

    }

}
