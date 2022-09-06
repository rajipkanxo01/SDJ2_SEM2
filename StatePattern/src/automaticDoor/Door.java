package automaticDoor;

public class Door {
    private DoorState doorState;

    public Door(DoorState initialState) {
        doorState = initialState;
    }

    public void setDoorState(DoorState state) {
        this.doorState = state;
    }

    public void openDoor () {
        doorState.openDoor(this);
        System.out.println("Opening Door!");
    }

    public void closeDoor() {
        doorState.closeDoor(this);
        System.out.println("Closing Door");
    }
}
