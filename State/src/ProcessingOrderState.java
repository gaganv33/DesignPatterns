public class ProcessingOrderState implements OrderState {
    @Override
    public void processOrder(OrderContext orderContext) {
        System.out.println("Order is already begin processed");
    }

    @Override
    public void shipOrder(OrderContext orderContext) {
        System.out.println("Order is shipped");
        orderContext.setOrderState(new ShippingOrderState());
    }

    @Override
    public void deliverOrder(OrderContext orderContext) {
        System.out.println("Cannot deliver an order that is not shipped");
    }

    @Override
    public void cancelOrder(OrderContext orderContext) {
        System.out.println("Order is cancelled");
        orderContext.setOrderState(new CancelOrderState());
    }
}
