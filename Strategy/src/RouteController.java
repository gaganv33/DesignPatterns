import java.util.*;

public class RouteController {
    private final Map<Double, List<List<Double>>> v;
    private RouteStrategy routeStrategy;

    public RouteController() {
        v = new HashMap<>();
        routeStrategy = new FastestRouteStrategy();
    }

    public void addEdge(double from, double to, double time, double cost, double beauty, double emission) {
        if(time <= 0 || cost <= 0 || beauty <= 0 || emission <= 0) {
            System.out.println("Invalid cost value");
            return;
        }
        if(!v.containsKey(from)) {
            v.put(from, new ArrayList<>());
        }
        if(!v.containsKey(to)) {
            v.put(to, new ArrayList<>());
        }
        v.get(from).add(new ArrayList<>(Arrays.asList(to, time, cost, beauty, emission)));
        v.get(to).add(new ArrayList<>(Arrays.asList(from, time, cost, beauty, emission)));
    }

    public Path buildRoute(int src, int dest) {
        return routeStrategy.buildRoute(src, dest, v);
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }
}
