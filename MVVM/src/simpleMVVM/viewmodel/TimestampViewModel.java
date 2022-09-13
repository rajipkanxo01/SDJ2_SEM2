package simpleMVVM.viewmodel;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import simpleMVVM.model.DataModel;

public class TimestampViewModel {

    private StringProperty updateTimeStamp;
    private DataModel model;
    private StringProperty numberOfUpdate;

    public TimestampViewModel(DataModel model) {
        this.model = model;
        updateTimeStamp = new SimpleStringProperty("Last update: ");
        numberOfUpdate = new SimpleStringProperty("Number of Update:");
    }

    public void updateTimestamp() {
        updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
        model.increaseNumberOfUpdates();
        numberOfUpdate.setValue("Number of Update: " + model.getNumberOfUpdates());
    }


    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }

    public StringProperty numberOfUpdate() {

        return numberOfUpdate;
    }
}
