package trafficLight;

public class Taxi {
    private String previousLight;
    private int id;

    public Taxi(int id) {
        this.id = id;
    }

    public void setLight(String currentLight) {
        if ("GREEN".equals(currentLight)) {
            System.out.println("Taxi " + id + " drives");
        } else if ("YELLOW".equals(currentLight)) {
            if ("RED".equals(previousLight)) {
                System.out.println("Taxi " + id + " turns engine on");
            } else {
                System.out.println("Taxi " + id + " continues to drive ");
            }
        } else if ("RED".equals(currentLight)) {
            System.out.println("Taxi " + id + " stops");
        }
        previousLight = currentLight;
    }
}
