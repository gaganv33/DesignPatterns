package carManager;

public class SmallCarManager extends CarManager {
    private static volatile CarManager instance;
    private SmallCarManager() {
        super();
    }

    public static CarManager getInstance() {
        if(instance == null) {
            synchronized (SmallCarManager.class) {
                if(instance == null) {
                    instance = new SmallCarManager();
                }
            }
        }
        return instance;
    }
}
