package edu.Sim3Lr6.service.students;

import edu.Sim3Lr6.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();
    Student getStudent(int id);
    Student saveStudent(Student student);
    Student putStudent(Student student,int id);
    void deleteStudent(int id);
}
