package temperaturePresenter.core;

import temperaturePresenter.view.temperature.TemperatureViewModel;

public class ViewModelFactory {
    private ModelFactory mf;
    private TemperatureViewModel viewModel;

    public ViewModelFactory(ModelFactory mf) {
        this.mf = mf;
    }

    public TemperatureViewModel getTemperatureViewModel () {
        if (viewModel == null) {
            viewModel = new TemperatureViewModel(mf.getTemperatureModel());
        }
        return viewModel;
    }
}
