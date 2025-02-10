public class CancelOrderState implements OrderState {
    @Override
    public void processOrder(OrderContext orderContext) {
        System.out.println("Cannot process an order that is cancelled");
    }

    @Override
    public void shipOrder(OrderContext orderContext) {
        System.out.println("Cannot ship an order that is cancelled");
    }

    @Override
    public void deliverOrder(OrderContext orderContext) {
        System.out.println("Cannot deliver an order that is cancelled");
    }

    @Override
    public void cancelOrder(OrderContext orderContext) {
        System.out.println("Order is already cancelled");
    }
}
