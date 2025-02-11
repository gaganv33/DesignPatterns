import java.util.ArrayList;
import java.util.List;

public class Path {
    public Double cost;
    public List<Integer> path;
    public Path(double cost, List<Integer> path) {
        this.cost = cost;
        this.path = path;
    }
}
