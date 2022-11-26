package producerConsumer;

import adapter.Deposit;
import singletonMultiton.Log;
import singletonMultiton.Valuable;

public class Miner implements Runnable {
    private Deposit deposit;
    private Log log;
    private Valuable valuable;
    private Mine mine;

    public Miner(Deposit deposit, Mine mine) {
        this.deposit = deposit;
        this.mine = mine;

        log = Log.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            valuable = mine.mineValuable();
//            log.printLog(valuable + " added into the deposit");
            deposit.add(valuable);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
