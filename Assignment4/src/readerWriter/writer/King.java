package readerWriter.writer;

import readerWriter.TreasureRoomDoor;
import singletonMultiton.Log;
import singletonMultiton.Valuable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class King implements Runnable {
    private Log log;
    private TreasureRoomDoor treasureRoom;
    private List<Valuable> valuables;

    public King(TreasureRoomDoor treasureRoom) {
        this.treasureRoom = treasureRoom;
        valuables = new ArrayList<>();

        log = Log.getInstance();
    }

    @Override
    public void run() {
//        Random random = new Random();
//        boolean party = true;
//        while (true) {
//            treasureRoom.acquireWrite();
//            log.printLog("\n King is counting valuables to host party!!!");
//            int value = random.nextInt(20, 50);
//            while (valuables.size() >= value) {
//                Valuable valuable = treasureRoom.retrieveValuable();
//                valuables.add(valuable);
//                if (treasureRoom.lookValuables() < value) {
//                    log.printLog("Not Enough Valuables! King cancelled the party!");
//                    party = false;
//                    break;
//                }
//            }
//            if (!party) {
//                for (Valuable valuable : valuables) {
//                    treasureRoom.addValuable(valuable);
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    break;
//                }
//            } else {
//                log.printLog("King is throwing party !!! Enjoy Everyone \n");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//
//        }
    }
}
