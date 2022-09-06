package radiator;

public class Power3State implements RadiatorState {
    private int POWER = 3;
    private Thread thread;

    public Power3State(Radiator radiator) {
        thread = new Thread(() -> {
            try {
                Thread.sleep(10000);
                turnDown(radiator);
                System.out.println("State Changed");
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        });
        thread.start();
        thread.setDaemon(true);
    }

    @Override
    public void turnUp(Radiator radiator) {
        // nothing happens
    }

    @Override
    public void turnDown(Radiator radiator) {
        thread.interrupt();
        radiator.setPowerState(new Power2State());
    }

    @Override
    public int getPower() {

        return POWER;
    }
}
