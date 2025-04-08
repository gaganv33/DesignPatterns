package carManager;

public class LargeCarManager extends CarManager {
    private static volatile CarManager instance;
    private LargeCarManager() {
        super();
    }

    public static CarManager getInstance() {
        if(instance == null) {
            synchronized (LargeCarManager.class) {
                if(instance == null) {
                    instance = new LargeCarManager();
                }
            }
        }
        return instance;
    }
}
