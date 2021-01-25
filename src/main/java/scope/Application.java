package scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class Application {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Message message = (Message) context.getBean("getMessage");
        message.setMessage("Message in main");
        System.out.println(message);

        Message message1 = (Message) context.getBean("getMessage");
        System.out.println(message1);
    }
}
