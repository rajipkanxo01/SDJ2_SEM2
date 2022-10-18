package timeStamp.core;

import timeStamp.model.DataModel;
import timeStamp.model.DataModelManager;

public class ModelFactory {

    private DataModel dataModel;

    public DataModel getDataModel() {
        if(dataModel == null) {
            dataModel = new DataModelManager();
        }
        return dataModel;
    }


}
