package pieChart.core;

import pieChart.model.DataModel;
import pieChart.model.DataModelManager;

public class ModelFactory {

    private DataModel dataModel;

    public DataModel getDataModel() {
        if(dataModel == null) {
            dataModel = new DataModelManager();
        }
        return dataModel;
    }


}
