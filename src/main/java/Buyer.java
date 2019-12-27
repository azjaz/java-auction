import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Phaser;

public class Buyer implements Runnable{
    Random limit = new Random();
    private final int moneyLimit = limit.nextInt(1500);
    Lot lot;
    Phaser auction;
    boolean isInGame = false;
    private int currentPrice;
    private List<Lot> wonLots = new ArrayList<>();

    public Buyer(Lot lot, Phaser auction) {
        this.lot = lot;
        this.auction = auction;
    }

    @Override
    public void run() {
        try {
        System.out.println(Thread.currentThread().getName() + " is registered " + " moneyLimit is " + moneyLimit);
            while (auction.getRegisteredParties() - 1 != 0) {
            currentPrice = lot.getPrice();
            System.out.println("current price is " + currentPrice);
            if ((currentPrice + Starter.PRICE_PATH) < moneyLimit) {
                synchronized (lot) {
                    lot.setPrice(lot.getPrice() + Starter.PRICE_PATH);
                }
                Thread.sleep(2000);
                isInGame = true;
                auction.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName() + " bid");

            }  else {
                if(auction.getRegisteredParties() == 1){
                    isInGame = true;
                    break;
                }
                    auction.arriveAndDeregister();
                    isInGame = false;
                System.out.println(Thread.currentThread().getName() + " deregister");

                    break;
                }
                Thread.sleep(2000);
            }
        System.out.println(Thread.currentThread().getName() + " left auction");
        Thread.sleep(2000);
        if(isInGame) {
            lot.setPaid(true);
            wonLots.add(lot);
            System.out.println(Thread.currentThread().getName() + " won lot!");
        }
        } catch (InterruptedException e) {e.getStackTrace();}
    }

    public List<Integer> getWonLots() {
        List<Integer> wonLotsIds = new ArrayList<>();
        for (Lot lot : wonLots) {
            wonLotsIds.add(lot.getLotId());
        }

        return wonLotsIds;
    }
}

