package upperCaseSocketsMVVM.server.model;



import upperCaseSocketsMVVM.shared.transferobjects.LogEntry;
import upperCaseSocketsMVVM.shared.util.Subject;

import java.util.List;

public interface TextManager extends Subject {

    String toUppercase(String str);
    List<LogEntry> getLog();
}
