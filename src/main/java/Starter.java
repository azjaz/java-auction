public class Starter {
    public static void main(String[] args) {
        Lot[] lots = {new Lot(0, 50),
                new Lot(1, 100),
                new Lot(2, 120)};

        new Thread(new Buyer()).start();
        new Thread(new Buyer()).start();
        new Thread(new Buyer()).start();
    }
}
