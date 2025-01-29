import java.io.Serial;
import java.io.Serializable;

public class SerializableSingleton implements Serializable {
    private static volatile SerializableSingleton serializableSingleton = null;
    private SerializableSingleton() {

    }
    public static SerializableSingleton getInstance() {
        if(serializableSingleton == null) {
            synchronized (SerializableSingleton.class) {
                if(serializableSingleton == null) {
                    serializableSingleton = new SerializableSingleton();
                }
            }
        }
        return serializableSingleton;
    }

    @Serial
    protected Object readResolve() {
        return serializableSingleton;
    }
}
