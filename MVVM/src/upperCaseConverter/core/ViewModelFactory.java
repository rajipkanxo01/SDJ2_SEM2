package upperCaseConverter.core;

import upperCaseConverter.view.UpperCaseViewModel;

public class ViewModelFactory {
    private UpperCaseViewModel upperCaseVM;
    private ModelFactory mf;

    public ViewModelFactory(ModelFactory mf) {
        this.mf = mf;
    }


    public UpperCaseViewModel getUpperCaseVM() {
        if (upperCaseVM == null) {
            upperCaseVM = new UpperCaseViewModel(mf.getTextConverter());
        }
        return upperCaseVM;
    }
}
