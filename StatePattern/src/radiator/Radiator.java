package radiator;

public class Radiator {
    private RadiatorState currentState;

    public Radiator(RadiatorState initialState) {
        currentState = initialState;
    }

    public void turnUp() {
        currentState.turnUp(this);
    }

    public void turnDown() {
        currentState.turnDown(this);
    }

    public void getPower() {
        System.out.println(currentState.getPower());
    }

    void setPowerState(RadiatorState state) {
        this.currentState = state;
    }

}
