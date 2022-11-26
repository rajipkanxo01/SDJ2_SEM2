package singletonMultiton;

public class Log {
    private static Log instance;
    private static Object lock = new Object();

    private Log() {

    }

    public static Log getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new Log();
            }
        }
        return instance;
    }

    public void printLog(String text) {
        System.out.println(text);
    }


}
