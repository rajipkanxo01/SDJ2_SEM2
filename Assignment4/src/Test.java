import adapter.Deposit;
import producerConsumer.Mine;
import producerConsumer.Miner;
import proxy.TreasureRoomGuardsMan;
import readerWriter.reader.Accountant;
import readerWriter.writer.King;
import readerWriter.writer.ValuableTransporter;
import readerWriter.TreasureRoom;
import readerWriter.TreasureRoomDoor;
import singletonMultiton.Valuable;

public class Test {
    public static void main(String[] args) {
        Deposit deposit = new Deposit(50);

        Mine mine = new Mine();
        Miner miner1 = new Miner(deposit, mine);
        Miner miner2 = new Miner(deposit, mine);

        TreasureRoomDoor treasureRoom = new TreasureRoom();

        ValuableTransporter transporter = new ValuableTransporter(deposit, treasureRoom);
        Accountant accountant = new Accountant(new TreasureRoomGuardsMan(treasureRoom));
        King king = new King(treasureRoom);

        Thread minerThread1 = new Thread(miner1);
        Thread minerThread2 = new Thread(miner2);
        Thread transporterThread = new Thread(transporter);
        Thread accountantTread = new Thread(accountant);
        Thread kingThread = new Thread(king);

        minerThread1.start();
        minerThread2.start();

        transporterThread.start();
        accountantTread.start();
        kingThread.start();

        Valuable diamond = Valuable.getValuable("GoldNugget");
        System.out.println(diamond.getValue());

    }
}
