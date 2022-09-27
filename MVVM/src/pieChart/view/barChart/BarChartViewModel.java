package pieChart.view.barChart;

import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import pieChart.model.DataModel;

public class BarChartViewModel {
    private DataModel model;

    private DoubleProperty x;
    private DoubleProperty y;
    private DoubleProperty z;
    private StringProperty timeStamp;

    public BarChartViewModel(DataModel model) {
        this.model = model;
        x = new SimpleDoubleProperty();
        y = new SimpleDoubleProperty();
        z = new SimpleDoubleProperty();
        timeStamp = new SimpleStringProperty();
    }

    public void updateBarChart() {
        double[] vals = model.getDataValues();
        x.setValue(vals[0]);
        y.setValue(vals[1]);
        z.setValue(vals[2]);
        timeStamp.setValue(model.getLastUpdateTimeStamp());
    }


    public ObservableValue xProperty() {
        return x;
    }

    public ObservableValue yProperty() {
        return y;
    }

    public ObservableValue zProperty() {
        return z;
    }

    public StringProperty timeStampProperty() {
        return timeStamp;
    }
}
