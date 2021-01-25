package profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class HolidaysInRussia implements HolidaysInCountry {
    public void comeOnVacation(String name) {
        System.out.println("Добро пожаловать в Сочи, " + name);
    }
}
