package trafficLight_V2;

public class RunTrafficLight {
    public static void main(String[] args) throws InterruptedException {
        TrafficLight trafficLight = new TrafficLight();
        Car car1 = new Car("01");
        Pedestrian pedestrian1 = new Pedestrian(trafficLight, "01");
        SleepyDriver sleepyDriver1 = new SleepyDriver(trafficLight, "01");

        trafficLight.addPropertyChangeListener(car1);
        trafficLight.start();
    }
}
