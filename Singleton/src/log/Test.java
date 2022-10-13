package log;

public class Test {
    public static void main(String[] args) {
//        LogLine logLine1 = new LogLine("Rajib");
//        LogLine logLine2 = new LogLine("Pow");
//        LogLine logLine3 = new LogLine("P.Einstein");

//        LogSingleton log = LogSingleton.getInstance();
        LogMultiton log = LogMultiton.getInstance("File");


        log.addLog("logLine1.toString()");
//        log.addLog(logLine2.toString());
//        log.addLog(logLine3.toString());


        System.out.println(log);

    }
}
