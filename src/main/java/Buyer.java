import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Buyer implements Runnable{
    Random limit = new Random();
    private final int moneyLimit = limit.nextInt(1500);
    Lot lot;
    boolean isInGame = false;
    private int currentPrice;
    private List<Lot> wonLots = new ArrayList<>();

    public Buyer(Lot lot) {
        this.lot = lot;
    }

    @Override
    public void run() {
        try {


//        Auction.AUCTION.register();
        System.out.println(Thread.currentThread().getName() + " is registered " + " moneyLimit is " + moneyLimit);
        do {
            currentPrice = lot.getPrice();
            System.out.println("current price is " + currentPrice);
            Thread.sleep(2000);
            if ((currentPrice + Auction.PRICE_PATH) < moneyLimit) {
                synchronized (lot) {
                    lot.setPrice(lot.getPrice() + Auction.PRICE_PATH);
                }
                isInGame = true;
                Auction.AUCTION.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName() + " bid");
                Thread.sleep(2000);
            }  else {
                    Auction.AUCTION.arriveAndDeregister();
                    isInGame = false;
                System.out.println(Thread.currentThread().getName() + " deregister");
                Thread.sleep(2000);
                    break;
                }

            } while (!(Auction.AUCTION.getRegisteredParties() - 1 == 0));
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

