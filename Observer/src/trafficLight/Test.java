package trafficLight;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car(01);
        Car car2 = new Car(02);
        Taxi taxi1 = new Taxi(01);
        Taxi taxi2 = new Taxi(02);
        Pedestrian pedestrian = new Pedestrian(01);

        TrafficLight light = new TrafficLight();
        light.addCar(car);
        light.addCar(car2);
        light.addTaxi(taxi1);
        light.addPedestrian(pedestrian);

        light.start();
    }
}
