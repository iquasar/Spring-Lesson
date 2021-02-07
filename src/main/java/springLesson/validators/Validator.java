package springLesson.validators;

public interface Validator {
    void validate(int value) throws ValidationException;
}
