public class Main {
    public static void main(String[] args) {
        OrderContext orderContext = new OrderContext();
        orderContext.processOrder();
        orderContext.processOrder();
        orderContext.shipOrder();
        orderContext.processOrder();
        orderContext.deliverOrder();
        orderContext.cancelOrder();
    }
}