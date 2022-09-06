package trafficLight;

public class SleepyDriver {
    private int id;
    private String previousLight;

    public SleepyDriver(int id) {
        this.id = id;
    }

    public void setLight(String currentLight) {
        if ("GREEN".equals(currentLight)) {
            System.out.println("Sleepy Driver " + id + " turns engine on");
            System.out.println("Sleepy Driver " + id + " drives");
        } else if ("YELLOW".equals(currentLight)) {
            if ("RED".equals(previousLight)) {
                System.out.println("Sleepy Driver " + id + " doesn't do anything");
            } else {
                System.out.println("Sleepy Driver " + id + " slows down");
            }
        } else if ("RED".equals(currentLight)) {
            System.out.println("Sleepy Driver " + id + " sstops");
        }
        previousLight = currentLight;
    }
}
