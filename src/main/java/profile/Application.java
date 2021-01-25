package profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Application {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext("profile");
        TravelAgency travelAgency = context.getBean(TravelAgency.class);
        travelAgency.goOnVacation("Вася");
    }
}
