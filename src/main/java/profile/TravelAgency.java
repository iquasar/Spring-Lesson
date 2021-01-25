package profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TravelAgency {
    private HolidaysInCountry holidaysInCountry;

    @Autowired
    public TravelAgency(@Qualifier("service") HolidaysInCountry holidaysInCountry) {
        this.holidaysInCountry = holidaysInCountry;
    }

    void goOnVacation(String name) {
        holidaysInCountry.comeOnVacation(name);
    }
}
