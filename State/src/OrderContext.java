public class OrderContext {
    private OrderState orderState;

    public OrderContext() {
        orderState = new NewOrderState();
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public void processOrder() {
        orderState.processOrder(this);
    }

    public void shipOrder() {
        orderState.shipOrder(this);
    }

    public void deliverOrder() {
        orderState.deliverOrder(this);
    }

    public void cancelOrder() {
        orderState.cancelOrder(this);
    }
}
