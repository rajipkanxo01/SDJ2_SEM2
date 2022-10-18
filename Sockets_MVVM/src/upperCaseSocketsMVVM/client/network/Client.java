package upperCaseSocketsMVVM.client.network;


import upperCaseSocketsMVVM.shared.transferobjects.LogEntry;
import upperCaseSocketsMVVM.shared.util.Subject;

import java.util.List;

public interface Client extends Subject {

    String toUppercase(String str);
    List<LogEntry> getLog();

    void startClient();
}
