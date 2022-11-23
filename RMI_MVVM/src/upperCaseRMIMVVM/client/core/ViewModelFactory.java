package upperCaseRMIMVVM.client.core;


import upperCaseRMIMVVM.client.views.log.LogViewModel;
import upperCaseRMIMVVM.client.views.uppercase.UppercaseViewModel;

public class ViewModelFactory {

    private final ModelFactory mf;
    private UppercaseViewModel uppercaseViewModel;
    private LogViewModel logViewModel;

    public ViewModelFactory(ModelFactory mf) {
        this.mf = mf;
    }

    public UppercaseViewModel getUppercaseViewModel() {
        if (uppercaseViewModel == null) {
            uppercaseViewModel = new UppercaseViewModel(mf.getTextConverter());
        }
        return uppercaseViewModel;
    }

    public LogViewModel getLogViewModel() {
        if (logViewModel == null) {
            logViewModel = new LogViewModel(mf.getTextConverter());
        }
        return logViewModel;
    }
}
