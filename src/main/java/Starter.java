public class Starter {
    public static void main(String[] args) {
        Lot[] lots = {new Lot(0, 50),
                new Lot(1, 100),
                new Lot(2, 120)};
        Thread buyer1 = new Thread(new Buyer(), "Buyer1");
        Thread buyer2 = new Thread(new Buyer(), "Buyer2");
        Thread buyer3 = new Thread(new Buyer(), "Buyer3");

        for (Lot lot : lots) {
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
