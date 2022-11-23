package upperCaseRMIMVVM.server.model;



import upperCaseRMIMVVM.shared.transferobjects.LogEntry;
import upperCaseRMIMVVM.shared.util.Subject;

import java.util.List;

public interface TextManager extends Subject {

    String toUppercase(String str);
    List<LogEntry> getLog();
}
