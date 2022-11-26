package log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LogMultiton {

    private static  Map<String, LogMultiton> map = new HashMap<>();
    private String fileName;
    private ArrayList<LogLine> lines = new ArrayList<>();

    private LogMultiton(String fileName) {
        this.fileName = fileName;
    }

    public Map<String, LogMultiton> getAll() {
        return map;
    }

    public void addLog(String text) {
//        LogMultiton log = new LogMultiton(text);
        LogLine logLine = new LogLine(text);
        lines.add(logLine);
        addToFile(logLine);
    }

    public static LogMultiton getInstance(String fileName) {
        LogMultiton instance = map.get(fileName);
        if (instance == null) {
            synchronized (map) {
                instance = map.get(fileName);
                if (instance == null) {
                    instance = new LogMultiton(fileName);
                    map.put(fileName, instance);
                }
            }
        }
        return instance;
    }


    private void addToFile(LogLine log) {
        if (log == null) {
            return;
        }
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(fileName, true));
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

    @Override
    public String toString() {
        return "LogMultiton{" +
                "fileName='" + fileName + '\'' +
                '}';
    }
}
