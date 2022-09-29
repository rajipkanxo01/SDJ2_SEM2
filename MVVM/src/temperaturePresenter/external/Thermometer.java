package temperaturePresenter.external;

import temperaturePresenter.mediator.TemperatureModel;

public class Thermometer implements Runnable {
    private double t; // last measured temperature
    private String id;
    private int d; // distance between heater and measurements
    private TemperatureModel temperatureModel;

    public Thermometer(TemperatureModel temperatureModel, double t, String id, int d) {
        this.temperatureModel = temperatureModel;
        this.t = t;
        this.id = id;
        this.d = d;
    }

    // tO: the outdoor temperature , s: number of seconds since last measurement , p: power of heater
    private double temperature(double t, int p, int d, double t0, int s) {

        double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
        double heaterTerm = 0;
        if (p > 0) {
            double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
            heaterTerm = 30 * s * Math.abs(tMax - t) / den;
        }
        double outDoorTerm = (t - t0) * s / 250.0;
        t = Math.min(Math.max(t - outDoorTerm + heaterTerm, t0), tMax);

        return t;
    }

    @Override
    public void run() {
        while (true) {
            t = temperature(t,2,d,0,6);
            temperatureModel.addTemperature(id,t);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
