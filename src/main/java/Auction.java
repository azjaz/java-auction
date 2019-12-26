import java.util.concurrent.Phaser;


public class Auction {

    public static final Phaser AUCTION = new Phaser(3);
    public static final int PRICE_PATH = 100;

//        auction.register();
//        Buyer buyer = new Buyer();
//        int currentPrice = lot.getPrice();
//        int moneyLimit = limit.nextInt(1500);
//        try {
//            Thread.sleep(1000);
//
//            while (auction.getRegisteredParties() != 1) {
//                if (currentPrice < moneyLimit) {
//                    synchronized (lot) {
//                        lot.setPrice(currentPrice + pricePath);
//                    }
//                    auction.arriveAndAwaitAdvance();
//                } else {
//                    auction.arriveAndDeregister();
//                    break;
//                }
//
//            }
//            if (auction.getRegisteredParties() == 1) {
//                buyer.wonLots.add(lot);
//            }
//
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}

