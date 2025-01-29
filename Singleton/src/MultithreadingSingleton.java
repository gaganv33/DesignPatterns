import java.io.Serializable;

public class MultithreadingSingleton implements Serializable {
    private static MultithreadingSingleton multithreadingSingleton = null;
    private MultithreadingSingleton() {

    }
    public static MultithreadingSingleton getInstance(){
        if(multithreadingSingleton == null) {
            synchronized (MultithreadingSingleton.class) {
                if(multithreadingSingleton == null) {
                    multithreadingSingleton = new MultithreadingSingleton();
                }
            }
        }
        return multithreadingSingleton;
    }
}
