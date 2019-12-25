import java.util.Random;
import java.util.concurrent.Phaser;


public class Auction {
    Lot[] lots = {new Lot(0, 50, false),
            new Lot(1, 100, false),
            new Lot(2, 120, false)};
    int counter = 0;
    Random limit = new Random();
    int pricePath = 100;

    public void sellingAllTheWays(Phaser auction, Lot lot) {
        auction.register();
        Buyer buyer = new Buyer();
        int currentPrice = lot.getPrice();
        int moneyLimit = limit.nextInt(1500);
        try {
            Thread.sleep(1000);

            while(auction.getRegisteredParties() != 1) {
                if(currentPrice < moneyLimit) {
                    synchronized(lot) {
                        lot.setPrice(currentPrice + pricePath);
                    }
                    auction.arriveAndAwaitAdvance();
                } else {
                    auction.arriveAndDeregister();
                    break;
                }

            }
            if(auction.getRegisteredParties() == 1) {
                buyer.wonLots.add(lot);
            }



        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}
