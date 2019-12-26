import java.util.Random;

public class Buyer implements Runnable{
    Random limit = new Random();
    private final int moneyLimit = limit.nextInt(1500);
    Lot lot;


    @Override
    public void run() {

        boolean isInGame = false;
        Auction.AUCTION.register();

        synchronized (lot) {
            if ((lot.getPrice() + Auction.PRICE_PATH) < moneyLimit) {
                lot.setPrice(lot.getPrice() + Auction.PRICE_PATH);
                Auction.AUCTION.arriveAndAwaitAdvance();
            } else {
                Auction.AUCTION.arriveAndDeregister();
            }
        }
    }
}

