package readerWriter.reader;

import readerWriter.TreasureRoomDoor;
import singletonMultiton.Log;

public class Accountant implements Runnable {
    private Log log;
    private TreasureRoomDoor treasureRoom;

    public Accountant(TreasureRoomDoor treasureRoom) {
        this.treasureRoom = treasureRoom;

        log = Log.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            treasureRoom.acquireRead();
            int valuables = treasureRoom.lookValuables();
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.printLog("\nAccountant finished counting number of valuables!!!");
            log.printLog("Number of Valuables: " + valuables + "\n");

            treasureRoom.releaseRead();
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
