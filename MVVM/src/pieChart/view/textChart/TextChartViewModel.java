package pieChart.view.textChart;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import pieChart.model.DataModel;

public class TextChartViewModel {
    private StringProperty x;
    private StringProperty y;
    private StringProperty z;
    private StringProperty timeStamp;

    private DataModel model;

    public TextChartViewModel(DataModel model) {
        this.model = model;
        x = new SimpleStringProperty();
        y = new SimpleStringProperty();
        z = new SimpleStringProperty();
        timeStamp = new SimpleStringProperty();
    }

    public void updateTextFields() {
        double[] values = model.getDataValues();
        x.setValue(String.valueOf(values[0]));
        y.setValue(String.valueOf(values[1]));
        z.setValue(String.valueOf(values[2]));
        timeStamp.setValue(model.getLastUpdateTimeStamp());
    }

    public void saveChanges() {
        double xDouble = Double.parseDouble(x.getValue());
        double yDouble = Double.parseDouble(y.getValue());
        double zDouble = Double.parseDouble(z.getValue());

        double[] data = {xDouble, yDouble, zDouble};
        model.saveData(data);
    }

    public StringProperty xProperty() {
        return x;
    }

    public StringProperty yProperty() {
        return y;
    }

    public StringProperty zProperty() {
        return z;
    }


    public StringProperty timeStampProperty() {
        return timeStamp;
    }
}
