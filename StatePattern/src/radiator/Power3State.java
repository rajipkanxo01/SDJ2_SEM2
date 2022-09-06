package radiator;

public class Power3State implements RadiatorState {
    private int POWER = 3;


    public Power3State() {
        new Thread(() -> {
            try {
                Thread.sleep(10000);
                Radiator radiator = new Radiator(new Power2State());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        ).start();
    }

    @Override
    public void turnUp(Radiator radiator) {
        // nothing happens
    }

    @Override
    public void turnDown(Radiator radiator) {

        POWER = 3;
        radiator.setPowerState(new Power2State());
    }

    @Override
    public int getPower() {

        return POWER;
    }
}
