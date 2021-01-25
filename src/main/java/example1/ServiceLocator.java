package example1;

public class ServiceLocator {
    //заглушка
    public static Sender getService(String className) {
        return new KafkaSender();
    }

}
