package timeStamp.model;

import java.util.Date;

public interface DataModel {

    String getLastUpdateTimeStamp();
    int getNumberOfUpdates();
    void setTimeStamp(Date timeStamp);
}
