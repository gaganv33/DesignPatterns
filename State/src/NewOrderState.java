public class NewOrderState implements OrderState {
    @Override
    public void processOrder(OrderContext orderContext) {
        System.out.println("Processing the order");
        orderContext.setOrderState(new ProcessingOrderState());
    }

    @Override
    public void shipOrder(OrderContext orderContext) {
        System.out.println("Cannot ship an order that is not processed");
    }

    @Override
    public void deliverOrder(OrderContext orderContext) {
        System.out.println("Cannot deliver an order that is not shipped");
    }

    @Override
    public void cancelOrder(OrderContext orderContext) {
        System.out.println("Order cancelled");
        orderContext.setOrderState(new CancelOrderState());
    }
}
