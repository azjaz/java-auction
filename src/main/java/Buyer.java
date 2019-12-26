import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Buyer implements Runnable{
    Random limit = new Random();
    private final int moneyLimit = limit.nextInt(1500);
    Lot lot;
    boolean isInGame = false;
    private int currentPrice;
    private List<Lot> wonLots = new ArrayList<>();

    @Override
    public void run() {

        Auction.AUCTION.register();
        do {
            currentPrice = lot.getPrice();
            if ((currentPrice + Auction.PRICE_PATH) < moneyLimit) {
                synchronized (lot) {
                    lot.setPrice(lot.getPrice() + Auction.PRICE_PATH);
                }
                isInGame = true;
                Auction.AUCTION.arriveAndAwaitAdvance();
            }  else {
                    Auction.AUCTION.arriveAndDeregister();
                    isInGame = false;
                    break;
                }

            } while (Auction.AUCTION.getRegisteredParties() - 1 == 0);

        if(isInGame) {
            lot.setPaid(true);
            wonLots.add(lot);
        }

    }

    public List<Lot> getWonLots() {
        return wonLots;
    }
}

