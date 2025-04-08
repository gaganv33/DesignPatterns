package carManager;

public class MediumCarManager extends CarManager {
    private static volatile CarManager instance;
    private MediumCarManager() {
        super();
    }

    public static CarManager getInstance() {
        if(instance == null) {
            synchronized (MediumCarManager.class) {
                if(instance == null) {
                    instance = new MediumCarManager();
                }
            }
        }
        return instance;
    }
}
