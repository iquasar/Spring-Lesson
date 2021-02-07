package springLesson.dao;

import springLesson.service.Student;

import java.util.List;

public interface StudentDao {
    void createStudentTable();
    void fillStudentTable(List<Student> students);
    void printAllStudentFromTable();
}
