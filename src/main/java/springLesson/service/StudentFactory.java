package springLesson.service;

import org.springframework.stereotype.Component;

@Component
public class StudentFactory {
    public Student createStudent() {
        return new Student();
    }
}
