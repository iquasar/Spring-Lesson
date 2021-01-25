package example2;
//
//import example2.settings.BeanConfig;
import example2.settings.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Application {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        CashMachine machine = context.getBean(CashMachine.class);
        machine.deposit();
    }
}
