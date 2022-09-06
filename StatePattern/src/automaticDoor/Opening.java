package automaticDoor;

public class Opening implements DoorState {


    public Opening() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Door Opened!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    @Override
    public void openDoor(Door door) {
        // nothing
    }

    @Override
    public void closeDoor(Door door) {
        door.setDoorState(new Closing(door));
    }
}
