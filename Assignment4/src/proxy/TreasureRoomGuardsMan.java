package proxy;

import readerWriter.TreasureRoom;
import readerWriter.TreasureRoomDoor;
import singletonMultiton.Valuable;

public class TreasureRoomGuardsMan implements TreasureRoomDoor {
    private TreasureRoomDoor treasureRoomDoor;
    private int readers;
    private boolean isWriting;
    private int waitingWriters;

    public TreasureRoomGuardsMan(TreasureRoomDoor treasureRoom) {
        this.treasureRoomDoor = treasureRoom;
    }

    @Override
    public void addValuable(Valuable valuable) {
        treasureRoomDoor.addValuable(valuable);
    }

    @Override
    public Valuable retrieveValuable() {
        return treasureRoomDoor.retrieveValuable();
    }

    @Override
    public int lookValuables() {
        return treasureRoomDoor.lookValuables();
    }

    @Override
    public int getTotalWorthOfValuables() {
        return treasureRoomDoor.getTotalWorthOfValuables();
    }

    @Override
    public synchronized void acquireRead() {
        // readers must wait if there are waiting writers
        while (isWriting || waitingWriters > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readers++;
    }

    @Override
    public synchronized void releaseRead() {
        readers--;
        if (readers == 0) {
            // notify all writers if there are no readers
            notifyAll();
        }
    }

    @Override
    public synchronized void acquireWrite() {
        waitingWriters++;
        while (readers > 0 || isWriting) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        waitingWriters--;
        isWriting = true;
    }

    @Override
    public synchronized void releaseWrite() {
        isWriting = false;
        notifyAll();
    }
}
