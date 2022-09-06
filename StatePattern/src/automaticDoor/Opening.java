package automaticDoor;

public class Opening implements DoorState {
    private Door door;


    public Opening(Door door) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Door Opened!");
                Thread.sleep(2000);
                System.out.println("Closing Door!");
                closeDoor(door);
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
