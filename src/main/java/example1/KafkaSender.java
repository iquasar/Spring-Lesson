package example1;

public class KafkaSender implements Sender {
    public void send(String message) {
        System.out.println("Сообщение было отправлено");
    }
}
