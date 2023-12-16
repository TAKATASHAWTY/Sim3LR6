package edu.Sim3Lr6.dao.students;

import edu.Sim3Lr6.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student putStudent(Student student, int id);
    Student getStudent(int id);
    void deleteStudent(int id);
}
