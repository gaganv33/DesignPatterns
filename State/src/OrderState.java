public interface OrderState {
    void processOrder(OrderContext orderContext);
    void shipOrder(OrderContext orderContext);
    void deliverOrder(OrderContext orderContext);
    void cancelOrder(OrderContext orderContext);
}
