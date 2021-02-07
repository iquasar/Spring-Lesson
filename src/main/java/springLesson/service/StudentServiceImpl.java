package springLesson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springLesson.aspects.TimeLog;
import springLesson.dao.StudentDao;
import springLesson.validators.ValidationException;
import springLesson.validators.Validator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class StudentServiceImpl implements StudentService {

    List<Student> studentList = new ArrayList<>();
    Validator validator;
    StudentFactory studentFactory;
    StudentDao studentDao;

    @Autowired
    void StudentService(Validator validator, StudentFactory studentFactory, StudentDao studentDao)
    {
        this.validator = validator;
        this.studentFactory = studentFactory;
        this.studentDao = studentDao;
    }

    @Override
    @TimeLog
    public void readStudentsFromFile() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("students.txt");
        List<String> stringList = new BufferedReader(new InputStreamReader(is)).lines().parallel().collect(Collectors.toList());

        for (int i = 0; i < stringList.size(); i++) {
            Student student = studentFactory.createStudent();
            String studName = stringList.get(i);
            student.setName(studName);
            studentList.add(student);
        }
    }

    @Override
    public void fillRating() {
        for (int i = 0; i < studentList.size(); i++) {
            String studName = studentList.get(i).getName();
            System.out.println("Оценка для: " + studName);
            try {
                Scanner sc = new Scanner(System.in);
                int rating = sc.nextInt();
                validator.validate(rating);
                studentList.get(i).setRating(rating);
            } catch (InputMismatchException | ValidationException ex) {
                System.out.println("Введите число в пределах от 1 до 5!");
                i--;
                continue;
            }
        }
    }

    @Override
    @TimeLog
    public void uploadToDataBase() throws Exception {
     System.out.println("UPLOAD TO DATABASE!");
     studentDao.createStudentTable();
     studentDao.fillStudentTable(studentList);
     studentDao.printAllStudentFromTable();
    }
}
