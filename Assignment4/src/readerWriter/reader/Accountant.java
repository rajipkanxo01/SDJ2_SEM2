package readerWriter.reader;

import readerWriter.TreasureRoomDoor;
import singletonMultiton.Log;

public class Accountant implements Runnable {
    private Log log;
    private TreasureRoomDoor guardsMan;

    public Accountant(TreasureRoomDoor guardsMan) {
        this.guardsMan = guardsMan;

        log = Log.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            guardsMan.acquireRead();
            int valuables = guardsMan.lookValuables();
            int totalValuableWorth = guardsMan.getTotalWorthOfValuables();
            log.printLog("\nAccountant started counting number of valuables!!!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.printLog("\nAccountant finished counting number of valuables!!!");
            log.printLog("Number of Valuables: " + valuables);
            log.printLog("Total Worth of Valuables: " + totalValuableWorth + "\n");

            guardsMan.releaseRead();
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
