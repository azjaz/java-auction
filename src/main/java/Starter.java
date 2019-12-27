import java.util.concurrent.Phaser;

public class Starter {

    public static final int PRICE_PATH = 100;
    public static void main(String[] args) {

        Lot[] lots = {new Lot(0, 50),
                new Lot(1, 100),
                new Lot(2, 120)};


        for (Lot lot : lots) {
            Phaser auction = new Phaser(3);
            Thread buyer1 = new Thread(new Buyer(lot, auction), "Buyer1");
            Thread buyer2 = new Thread(new Buyer(lot, auction), "Buyer2");
            Thread buyer3 = new Thread(new Buyer(lot, auction), "Buyer3");
            buyer1.start();
            buyer2.start();
            buyer3.start();

            try {
                buyer1.join();
                buyer2.join();
                buyer3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
