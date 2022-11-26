package readerWriter.writer;

import adapter.Deposit;
import readerWriter.TreasureRoomDoor;
import singletonMultiton.Log;
import singletonMultiton.Valuable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ValuableTransporter implements Runnable {
    private Deposit deposit;
    private List<Valuable> transportingValuables;
    private TreasureRoomDoor treasureRoom;
    private Log log;

    public ValuableTransporter(Deposit deposit, TreasureRoomDoor treasureRoom) {
        this.deposit = deposit;
        this.treasureRoom = treasureRoom;

        log = Log.getInstance();
        transportingValuables = new ArrayList<>();

    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            int number = 1;
            int target = random.nextInt(1, 10);
            log.printLog("\nCan Carry:" + target + " valuables \n");
            while (target >= transportingValuables.size()) {
                Valuable valuable = deposit.get(0);
                log.printLog("Valuable " + number + " added for transporting to treasure room");
                number++;
                transportingValuables.add(valuable);
            }
            log.printLog("Target reached for transporter.");
            log.printLog("Now.. Transporting to Treasure Room!!!");
            treasureRoom.acquireWrite();
            for (Valuable transportingValuable : transportingValuables) {
                treasureRoom.addValuable(transportingValuable);
            }
            transportingValuables.clear();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            treasureRoom.releaseWrite();
            log.printLog("Returned from treasure room \n");
        }
    }
}
