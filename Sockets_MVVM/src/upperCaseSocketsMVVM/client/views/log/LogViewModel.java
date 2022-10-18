package upperCaseSocketsMVVM.client.views.log;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import upperCaseSocketsMVVM.client.model.TextConverter;
import upperCaseSocketsMVVM.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class LogViewModel {

    private ObservableList<LogEntry> logs;

    private TextConverter textConverter;

    public LogViewModel(TextConverter textConverter) {
        this.textConverter = textConverter;
        textConverter.addListener("NewLogEntry", this::onNewLogEntry);
    }

    private void onNewLogEntry(PropertyChangeEvent evt) {
        logs.add((LogEntry)evt.getNewValue());
    }

    void loadLogs() {
        List<LogEntry> logList = textConverter.getLogs();
        logs = FXCollections.observableArrayList(logList);
    }

    ObservableList<LogEntry> getLogs() {
        return logs;
    }
}
