package springLesson;

import org.springframework.context.annotation.*;
import org.springframework.context.support.AbstractApplicationContext;
import springLesson.service.StudentService;

public class Main {

    public static void main(String[] args) throws Exception {
        AbstractApplicationContext springLesson = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        StudentService studentService = springLesson.getBean(StudentService.class);
        studentService.readStudentsFromFile();
        studentService.fillRating();
        studentService.uploadToDataBase();
    }
}
