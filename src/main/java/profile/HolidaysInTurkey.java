package profile;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("service")
public class HolidaysInTurkey  implements HolidaysInCountry{
    public void comeOnVacation(String name) {
        System.out.println("Welcome to Antalya, "+name);
    }
}
