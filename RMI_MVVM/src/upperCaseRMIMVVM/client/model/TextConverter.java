package upperCaseRMIMVVM.client.model;


import upperCaseRMIMVVM.shared.transferobjects.LogEntry;
import upperCaseRMIMVVM.shared.util.Subject;

import java.util.List;

public interface TextConverter extends Subject {

    String toUppercase(String text);
    List<LogEntry> getLogs();

}


