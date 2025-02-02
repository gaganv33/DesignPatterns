import java.util.HashMap;
import java.util.Map;

public class PostImpl implements Post {
    Map<Integer, String> data = new HashMap<>();

    public PostImpl() {
        data.put(0, "data - 0");
        data.put(1, "data - 1");
        data.put(2, "data - 2");
        data.put(3, "data - 3");
        data.put(4, "data - 4");
    }

    @Override
    public String getData(Integer id) {
        if(data.containsKey(id)) {
            return data.get(id);
        }
        String value = "data - " + Integer.toString(id);
        data.put(id, value);
        return value;
    }
}
