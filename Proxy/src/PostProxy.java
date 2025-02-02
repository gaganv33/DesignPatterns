import java.util.HashMap;
import java.util.Map;

public class PostProxy implements Post {
    Map<Integer, String> cache = new HashMap<>();
    private final Post post;

    public PostProxy() {
        this.post = new PostImpl();
    }

    @Override
    public String getData(Integer id) {
        if(cache.containsKey(id)) {
            return cache.get(id);
        }
        String data = post.getData(id);
        cache.put(id, data);
        return data;
    }
}
