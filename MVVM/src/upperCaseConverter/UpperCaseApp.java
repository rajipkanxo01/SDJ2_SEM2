package upperCaseConverter;

import javafx.application.Application;
import javafx.stage.Stage;
import upperCaseConverter.core.ModelFactory;
import upperCaseConverter.core.ViewHandler;
import upperCaseConverter.core.ViewModelFactory;

public class UpperCaseApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler viewHandler = new ViewHandler(vmf);

        viewHandler.start();
    }
}
