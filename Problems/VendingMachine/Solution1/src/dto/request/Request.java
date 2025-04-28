package dto.request;

public class Request {
    private final int shelfId;
    private final int quantity;

    public Request(int shelfId, int quantity) {
        this.shelfId = shelfId;
        this.quantity = quantity;
    }

    public int getShelfId() {
        return shelfId;
    }

    public int getQuantity() {
        return quantity;
    }
}
