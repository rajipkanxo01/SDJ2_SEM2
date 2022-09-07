package doctorsWaitingRoom;

public class test {
    public static void main(String[] args) {
        WaitingRoom waitingRoom = new WaitingRoom();
        for (int i = 0; i < 5; i++) {
            Patient patient = new Patient(i, waitingRoom);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
