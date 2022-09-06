package radiator;

public class Power2State implements RadiatorState {
    private int POWER = 2;

    @Override
    public void turnUp(Radiator radiator) {
        radiator.setPowerState(new Power3State());
    }

    @Override
    public void turnDown(Radiator radiator) {
        radiator.setPowerState(new Power1State());
    }

    @Override
    public int getPower() {
        return POWER;
    }
}
