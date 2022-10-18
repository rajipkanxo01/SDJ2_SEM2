package upperCaseSocketsMVVM.client.model;


import upperCaseSocketsMVVM.shared.transferobjects.LogEntry;
import upperCaseSocketsMVVM.shared.util.Subject;

import java.util.List;

public interface TextConverter extends Subject {

    String toUppercase(String text);
    List<LogEntry> getLogs();

}


