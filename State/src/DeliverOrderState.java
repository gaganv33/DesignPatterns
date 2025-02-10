public class DeliverOrderState implements OrderState {
    @Override
    public void processOrder(OrderContext orderContext) {
        System.out.println("Cannot process an order that is delivered");
    }

    @Override
    public void shipOrder(OrderContext orderContext) {
        System.out.println("Cannot ship an order that is delivered");
    }

    @Override
    public void deliverOrder(OrderContext orderContext) {
        System.out.println("Order is already delivered");
    }

    @Override
    public void cancelOrder(OrderContext orderContext) {
        System.out.println("Cannot cancel a order that is delivered");
    }
}
