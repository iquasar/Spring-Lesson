package lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Application {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        context.registerShutdownHook();
        Lifecycle bean = context.getBean(Lifecycle.class);
    }
}
