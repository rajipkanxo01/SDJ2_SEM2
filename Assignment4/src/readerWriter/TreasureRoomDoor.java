package readerWriter;

import singletonMultiton.Valuable;

public interface TreasureRoomDoor {
    void addValuable(Valuable valuable);

    Valuable retrieveValuable();

    int lookValuables();

    int getTotalWorthOfValuables();

    void acquireRead();

    void releaseRead();

    void acquireWrite();

    void releaseWrite();


}
