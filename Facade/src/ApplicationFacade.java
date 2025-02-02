public class ApplicationFacade {
    private final Restaurant restaurant = new Restaurant();
    private final DeliveryTeam deliveryTeam = new DeliveryTeam();

    public void placeOrder() {
        restaurant.prepareOrder();
        DeliveryBoy deliveryBoy = deliveryTeam.assignDeliveryBoy();
        deliveryBoy.pickUpOrder();
        deliveryBoy.deliverOrder();
    }
}
