package upperCaseRMIMVVM.client;

import javafx.application.Application;
import javafx.stage.Stage;
import upperCaseRMIMVVM.client.core.ModelFactory;
import upperCaseRMIMVVM.client.core.ViewHandler;
import upperCaseRMIMVVM.client.core.ViewModelFactory;
import upperCaseRMIMVVM.client.core.ClientFactory;

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
