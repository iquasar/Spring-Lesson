package example1;

public class MessageService {

    private Sender sender;

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public void send(String message) {
        sender.send(message);
    }
}
