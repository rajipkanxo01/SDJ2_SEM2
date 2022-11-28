package readerWriter;

import proxy.TreasureRoomGuardsMan;
import singletonMultiton.Log;
import singletonMultiton.Valuable;

import java.util.ArrayList;
import java.util.List;

public class TreasureRoom implements TreasureRoomDoor {
    private List<Valuable> valuables;
    private TreasureRoomDoor guardsMan;
    private Log log;

    public TreasureRoom() {
        guardsMan = new TreasureRoomGuardsMan(this);

        valuables = new ArrayList<>();
        log = Log.getInstance();
    }

    @Override
    public void addValuable(Valuable valuable) {
        valuables.add(valuable);
    }

    @Override
    public Valuable retrieveValuable() {
        if (valuables.isEmpty()) {
            log.printLog("Treasure Room is Empty!!");
        }
        return valuables.get(0);
    }

    @Override
    public int lookValuables() {
        return valuables.size();
    }

    @Override
    public int getTotalWorthOfValuables() {
        int value = 0;
        for (Valuable valuable : valuables) {
            value += valuable.getValue();
        }
        return value;
    }

    @Override
    public void acquireRead() {
        guardsMan.acquireRead();
    }

    @Override
    public void releaseRead() {
        guardsMan.releaseRead();
    }

    @Override
    public void acquireWrite() {
        guardsMan.acquireWrite();
    }

    @Override
    public void releaseWrite() {
        guardsMan.releaseWrite();
    }
}
