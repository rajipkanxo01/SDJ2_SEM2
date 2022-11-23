package upperCaseRMIMVVM.client.network;


import upperCaseRMIMVVM.shared.transferobjects.LogEntry;
import upperCaseRMIMVVM.shared.util.Subject;

import java.util.List;

public interface Client extends Subject {

    String toUppercase(String str);
    List<LogEntry> getLog();

    void startClient();
}
