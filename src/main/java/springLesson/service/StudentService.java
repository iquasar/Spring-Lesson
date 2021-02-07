package springLesson.service;

public interface StudentService {
    void readStudentsFromFile();

    void fillRating();

    void uploadToDataBase() throws Exception;
}
