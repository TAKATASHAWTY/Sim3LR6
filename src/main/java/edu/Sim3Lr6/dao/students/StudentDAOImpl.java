package edu.Sim3Lr6.dao.students;

import edu.Sim3Lr6.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Slf4j
@Repository
public class StudentDAOImpl implements StudentDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {

        Query query = entityManager.createQuery("from Student");
        List<Student> allStudents = query.getResultList();
        log.info("getAllStudents" + allStudents);
        if (allStudents.isEmpty()){
            log.error("ErrorTableIsEmpty!");
            return null;
        }

        log.info("SUCCESS");
        return allStudents;
    }

    @Override
    public Student saveStudent(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public Student putStudent(Student student, int id) {
        student.setId(id);

        if (getStudent(id) != null) {
            return entityManager.merge(student);
        } else {
            log.error("ErrorIsNull");
            return null;
        }
    }

    @Override
    public Student getStudent(int id){
        Student student = entityManager.find(Student.class, id);
        if (student == null){
            log.error("ErrorThisStringDoesn'tExist!");
            return null;
        }
        log.info("SUCCESS");
        return student;
    }

    @Override
    public void deleteStudent(int id){
        Query query = entityManager.createQuery("delete from Student where id =:studentId");
        query.setParameter("studentId", id);
        query.executeUpdate();
    }
}
