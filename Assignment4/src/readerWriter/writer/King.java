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
        Random random = new Random();
        int currentWorthValues = 0;
        boolean canKingHostParty = true;
        while (true) {
            int randomValue = random.nextInt(80, 200);
            log.printLog("\nRequired Valuable worth to party: " + randomValue);
            treasureRoom.acquireWrite();
            while (currentWorthValues <= randomValue) {
                System.out.println("\t" + treasureRoom.lookValuables() +  "\t");
                if (treasureRoom.lookValuables() == 0) {
                    canKingHostParty = false;
                    break;
                }
                Valuable valuable = treasureRoom.retrieveValuable();
                valuables.add(valuable);
                currentWorthValues += valuable.getValue();

            }
            if (!canKingHostParty) {
                for (Valuable tempValuable : valuables) {
                    treasureRoom.addValuable(tempValuable);
                }
                valuables.clear();
                log.printLog("Not Enough Valuables Worth!!! Can't host party!!!! \n");
            }

            if (canKingHostParty) {
                valuables.clear();
                log.printLog("Everyone enjoy kings party!! \n");

            }
            treasureRoom.releaseWrite();
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
