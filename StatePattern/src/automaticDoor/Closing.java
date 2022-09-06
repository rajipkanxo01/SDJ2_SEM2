package automaticDoor;

public class Closing implements DoorState {
    private Door door;

    public Closing(Door door) {
        new Thread(() -> {
            try {
                Thread.sleep(10000);
                door.setDoorState(new Closed());
                System.out.println("Door Closed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }

    @Override
    public void openDoor(Door door) {
        door.setDoorState(new Opening(door));
    }

    @Override
    public void closeDoor(Door door) {
        // closing
    }
}
