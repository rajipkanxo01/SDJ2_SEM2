package automaticDoor;

public class Closed implements DoorState {
    @Override
    public void openDoor(Door door) {
        door.setDoorState(new Opening() {
        });
    }

    @Override
    public void closeDoor(Door door) {
        // do nothing
    }
}
