public class Main {
    public static void main(String[] args) {
        final RouteController routeController = getRouteController();

        int src = 1;
        int dest = 15;

        Path path = routeController.buildRoute(src, dest);
        System.out.println("Fastest route: \n" + path.cost + "\n" + path.path);

        routeController.setRouteStrategy(new CheapestRouteStrategy());
        path = routeController.buildRoute(src, dest);
        System.out.println("Cheapest route: \n" + path.cost + "\n" + path.path);

        routeController.setRouteStrategy(new ScenicRouteStrategy());
        path = routeController.buildRoute(src, dest);
        System.out.println("Scenic route: \n" + path.cost + "\n" + path.path);

        routeController.setRouteStrategy(new EcoFriendlyRouteStrategy());
        path = routeController.buildRoute(src, dest);
        System.out.println("Eco friendly route: \n" + path.cost + "\n" + path.path);
    }

    private static RouteController getRouteController() {
        RouteController routeController = new RouteController();
        routeController.addEdge(1, 2, 1.5, 10, 5, 20);
        routeController.addEdge(1, 3, 2.0, 12, 7, 25);
        routeController.addEdge(1, 4, 2.8, 15, 6, 30);
        routeController.addEdge(2, 5, 1.2, 8, 6, 18);
        routeController.addEdge(2, 6, 3.0, 30, 3, 50);
        routeController.addEdge(3, 7, 3.5, 28, 6, 35);
        routeController.addEdge(3, 8, 2.6, 22, 5, 32);
        routeController.addEdge(4, 9, 1.8, 10, 5, 22);
        routeController.addEdge(4, 10, 3.4, 25, 7, 40);
        routeController.addEdge(5, 11, 2.3, 18, 6, 28);
        routeController.addEdge(5, 12, 2.9, 23, 5, 30);
        routeController.addEdge(6, 13, 2.6, 22, 4, 35);
        routeController.addEdge(6, 14, 4.1, 40, 3, 55);
        routeController.addEdge(7, 15, 3.2, 20, 7, 28);
        routeController.addEdge(8, 9, 2.4, 20, 7, 28);
        routeController.addEdge(9, 10, 2.1, 17, 6, 24);
        routeController.addEdge(10, 11, 2.8, 22, 5, 30);
        routeController.addEdge(11, 12, 2.2, 15, 4, 20);
        routeController.addEdge(12, 13, 3.6, 30, 3, 45);
        routeController.addEdge(13, 14, 2.7, 25, 4, 38);
        routeController.addEdge(14, 15, 3.0, 28, 6, 40);
        routeController.addEdge(7, 14, 2.5, 20, 8, 30);
        routeController.addEdge(8, 15, 2.8, 22, 6, 33);
        routeController.addEdge(5, 8, 1.75, 50, 2, 40);
        routeController.addEdge(2, 9, 3.3, 35, 5, 45);
        return routeController;
    }
}