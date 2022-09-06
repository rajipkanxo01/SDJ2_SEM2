package automaticDoor;

public class Open implements DoorState {
    @Override
    public void openDoor(Door door) {
        // do nothing
    }

    @Override
    public void closeDoor(Door door) {
        door.setDoorState(new Closing(door) {
        });
    }
}
