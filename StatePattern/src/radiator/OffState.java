package radiator;

public class OffState implements RadiatorState {
    private  int POWER = 0;

    @Override
    public void turnUp(Radiator radiator) {
        radiator.setPowerState(new Power1State());
    }

    @Override
    public void turnDown(Radiator radiator) {
        // nothing
    }

    @Override
    public int getPower() {
        return POWER;
    }
}
