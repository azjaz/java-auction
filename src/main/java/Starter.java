public class Starter {
    public static void main(String[] args) {
        Lot[] lots = {new Lot(0, 50, false),
                new Lot(1, 100, false),
                new Lot(2, 120, false)};

        new Thread(new Buyer()).start();
        new Thread(new Buyer()).start();
        new Thread(new Buyer()).start();
    }
}
