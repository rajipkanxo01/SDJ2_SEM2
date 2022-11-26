package readerWriter;

import singletonMultiton.Valuable;

public interface TreasureRoomDoor {
    void addValuable(Valuable valuable);

    Valuable retrieveValuable();

    int lookValuables();

    void acquireRead();

    void releaseRead();

    void acquireWrite();

    void releaseWrite();


}
