package edu.Sim3Lr6.controller;

import edu.Sim3Lr6.entity.Student;
import edu.Sim3Lr6.service.students.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> showAllStudents(){
        List<Student> allStudents = studentService.getAllStudents();
        return allStudents;
    }

    @GetMapping("/students/{id}")
    public Student getSudent(@PathVariable("id") int id) {return studentService.getStudent(id);}

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {return studentService.saveStudent(student);}

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return student;
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") int id){studentService.deleteStudent(id);}

}
