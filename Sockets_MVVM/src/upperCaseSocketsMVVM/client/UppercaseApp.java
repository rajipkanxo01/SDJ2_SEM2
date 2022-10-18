package upperCaseSocketsMVVM.client;

import javafx.application.Application;
import javafx.stage.Stage;
import upperCaseSocketsMVVM.client.core.ClientFactory;
import upperCaseSocketsMVVM.client.core.ModelFactory;
import upperCaseSocketsMVVM.client.core.ViewHandler;
import upperCaseSocketsMVVM.client.core.ViewModelFactory;

public class UppercaseApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory cf = new ClientFactory();
        ModelFactory mf = new ModelFactory(cf);
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }
}
