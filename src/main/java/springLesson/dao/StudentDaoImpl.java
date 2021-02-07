package springLesson.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import springLesson.service.Student;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate parameterJdbcTemplate;


    @Autowired
    public StudentDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.parameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void createStudentTable() {
        System.out.println("Создаем таблицу Student");
        jdbcTemplate.update("create table students(" +
                "name varchar2(256)," +
                "rating number(1)" +
                ")");

    }

    @Override
    public void fillStudentTable(List<Student> students) {
        SqlParameterSource[] sqlParameterSource = SqlParameterSourceUtils.createBatch(students.toArray());
        int[] updated = parameterJdbcTemplate.batchUpdate("insert into students (name, rating) values (:name, :rating)", sqlParameterSource);
        System.out.println("Сохранили " + Arrays.stream(updated).sum() + " запись(ей)");
    }

    @Override
    public void printAllStudentFromTable() {
        List<Map<String, Object>> students = jdbcTemplate.queryForList("select * from students");
        students.forEach(System.out::println);
    }
}
