package example2.service;

import org.springframework.stereotype.Component;

@Component
public class DepositValidator implements Validator {

    public void validate(long sum) {
        if (sum < 0) {
            throw new IllegalArgumentException("Сумма не может быть отрицательной");
        }
    }
}
