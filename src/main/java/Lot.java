public class Lot {

    private int lotId;
    private int price;
    private boolean isPaid = false;

    public Lot(int lotId, int price) {
        super();
        this.lotId = lotId;
        this.price = price;
    }
    public int getLotId() {
        return lotId;
    }
    public int getPrice() {
        return price;
    }
    public boolean isPaid() {
        return isPaid;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }


}
