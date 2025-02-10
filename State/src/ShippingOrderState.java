public class ShippingOrderState implements OrderState {
    @Override
    public void processOrder(OrderContext orderContext) {
        System.out.println("Cannot process an order that is in shipping state");
    }

    @Override
    public void shipOrder(OrderContext orderContext) {
        System.out.println("Order is already shipped");
    }

    @Override
    public void deliverOrder(OrderContext orderContext) {
        System.out.println("Order is delivered");
        orderContext.setOrderState(new DeliverOrderState());
    }

    @Override
    public void cancelOrder(OrderContext orderContext) {
        System.out.println("Order is cancelled");
        orderContext.setOrderState(new CancelOrderState());
    }
}
