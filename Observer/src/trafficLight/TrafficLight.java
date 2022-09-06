package trafficLight;

import java.util.ArrayList;
import java.util.List;

public class TrafficLight {

    List<Car> cars;
    List<Taxi> taxis;
    List<Pedestrian> pedestrians;
    private String[] lights = {"GREEN", "YELLOW", "RED", "YELLOW"};
    private int count = 2;
    private String currentLight;

    public TrafficLight() {
        currentLight = lights[2];
        cars = new ArrayList<>();
        taxis = new ArrayList<>();
        pedestrians = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
        car.setLight(currentLight);
    }

    public void addTaxi(Taxi taxi) {
        taxis.add(taxi);
        taxi.setLight(currentLight);
    }

    public void addPedestrian(Pedestrian pedestrian) {
        pedestrians.add(pedestrian);
        pedestrian.setLight(currentLight);
    }

    public void start() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(2000);
            count = (++count) % 4;
            currentLight = lights[count];
            System.out.println("\nLight is " + currentLight);
            lightChanged();
        }
    }

    private void lightChanged() {
        for (Car car : cars) {
            car.setLight(currentLight);
        }
        for (Taxi taxi : taxis) {
            taxi.setLight(currentLight);
        }
        for (Pedestrian pedestrian : pedestrians
        ) {
            pedestrian.setLight(currentLight);
        }
    }

}
