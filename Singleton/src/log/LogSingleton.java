package log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class LogSingleton {
    private ArrayList<LogLine> logLines;
    private static LogSingleton instance;
    private static Object lock = new Object();

    public LogSingleton() {
        logLines = new ArrayList<>();
    }

    public static LogSingleton getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new LogSingleton();
                }
            }
        }
        return instance;
    }

    public void addLog(String log) {
        LogLine logLine = new LogLine(log);
        logLines.add(logLine);
        addToFile(logLine);
    }

    public ArrayList<LogLine> getAll() {
        return logLines;
    }

    @Override
    public String toString() {
        return "Log{" + "logLines=" + logLines + '}';
    }

    private void addToFile(LogLine log) {
        if (log == null) {
            return;
        }
        BufferedWriter out = null;
        try {
            String filename = "Log-"
                    + log.getDateTime().getSortableDate() + ".txt";
            out = new BufferedWriter(new FileWriter(filename, true));
            out.write(log + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


