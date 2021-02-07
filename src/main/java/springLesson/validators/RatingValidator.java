package springLesson.validators;

import org.springframework.stereotype.Component;

@Component
public class RatingValidator implements Validator {
    public void validate(int value) throws ValidationException {
        if (value < 1 || value > 5) {
            throw new ValidationException();
        }
    }
}
