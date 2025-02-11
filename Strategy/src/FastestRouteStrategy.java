import java.util.*;

public class FastestRouteStrategy extends RouteStrategy {
    @Override
    public Path buildRoute(int src, int dest, Map<Double, List<List<Double>>> v) {
        int n = v.size();
        List<Integer> path = new ArrayList<>();
        List<Double> w = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            w.add(Double.MAX_VALUE);
            path.add(-1);
        }

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
            if(o1.cost < o2.cost) {
                return -1;
            } else if(o1.cost == o2.cost) {
                return 0;
            }
            return 1;
        });

        w.set(src, 0D);
        q.add(new Node(0.0, src));

        while(!q.isEmpty()) {
            Node node = q.poll();

            for(var list : v.get(node.node)) {
                double nextNode = list.get(0);
                double nextCost = list.get(1);

                if((nextCost + node.cost) < w.get((int) nextNode)) {
                    path.set((int) nextNode, (int) node.node);
                    w.set((int) nextNode, nextCost + node.cost);
                    q.add(new Node(node.cost + nextCost, nextNode));
                }
            }
        }
        if(w.get(dest) == Double.MAX_VALUE) {
            return new Path(Double.MAX_VALUE, new ArrayList<>());
        }
        return getPath(dest, path, w);
    }
}
