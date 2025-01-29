import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        checkMultithreadingSingletonForDeserialization();
        checkSerializableSingletonForDeserialization();
        checkSerializableSingletonForReflectionAPI();
        checkEnumSingletonForDeserialization();
        checkEnumSingletonForReflectionAPI();
    }

    static void checkMultithreadingSingletonForDeserialization() throws IOException, ClassNotFoundException {
        MultithreadingSingleton multithreadingSingleton = MultithreadingSingleton.getInstance();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.obj"));
        objectOutputStream.writeObject(multithreadingSingleton);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.obj"));
        MultithreadingSingleton instance = (MultithreadingSingleton) objectInputStream.readObject();
        objectOutputStream.close();

        System.out.println("Checking MultithreadingSingleton for Deserialization");
        System.out.println("Object 1 hash code: " + multithreadingSingleton.hashCode());
        System.out.println("Object 2 hash code: " + instance.hashCode());
    }

    static void checkSerializableSingletonForDeserialization() throws IOException, ClassNotFoundException {
        SerializableSingleton serializableSingleton = SerializableSingleton.getInstance();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.obj"));
        objectOutputStream.writeObject(serializableSingleton);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.obj"));
        SerializableSingleton instance = (SerializableSingleton) objectInputStream.readObject();
        objectOutputStream.close();

        System.out.println("Checking SerializableSingleton for Deserialization");
        System.out.println("Object 1 hash code: " + serializableSingleton.hashCode());
        System.out.println("Object 2 hash code: " + instance.hashCode());
    }

    static void checkSerializableSingletonForReflectionAPI() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        SerializableSingleton serializableSingleton = SerializableSingleton.getInstance();
        Constructor[] constructors = SerializableSingleton.class.getDeclaredConstructors();

        Constructor constructor = constructors[0];
        constructor.setAccessible(true);
        SerializableSingleton instance = (SerializableSingleton) constructor.newInstance();

        System.out.println("Checking SerializableSingleton for Reflection API");
        System.out.println("Object 1 hash code: " + serializableSingleton.hashCode());
        System.out.println("Object 2 hash code: " + instance.hashCode());
    }

    static void checkEnumSingletonForDeserialization() throws IOException, ClassNotFoundException {
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.obj"));
        objectOutputStream.writeObject(enumSingleton);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.obj"));
        EnumSingleton instance = (EnumSingleton) objectInputStream.readObject();
        objectOutputStream.close();

        System.out.println("Checking EnumSingleton for Deserialization");
        System.out.println("Object 1 hash code: " + enumSingleton.hashCode());
        System.out.println("Object 2 hash code: " + instance.hashCode());
    }

    static void checkEnumSingletonForReflectionAPI() {
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        Constructor[] constructors = EnumSingleton.class.getDeclaredConstructors();

        Constructor constructor = constructors[0];
        constructor.setAccessible(true);

       try {
           EnumSingleton instance = (EnumSingleton) constructor.newInstance();
           System.out.println("Checking EnumSingleton for Reflection API");
           System.out.println("Object 1 hash code: " + enumSingleton.hashCode());
           System.out.println("Object 2 hash code: " + instance.hashCode());
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
}