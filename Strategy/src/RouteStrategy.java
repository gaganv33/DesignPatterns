import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class RouteStrategy {
    public abstract Path buildRoute(int src, int dest, Map<Double, List<List<Double>>> v);

    protected final Path getPath(int dest, List<Integer> path, List<Double> w) {
        List<Integer> res = new ArrayList<>();
        int node = dest;
        while(node != -1) {
            res.add(node);
            node = path.get(node);
        }
        Collections.reverse(res);
        return new Path(w.get(dest), res);
    }
}
