package edu.Sim3Lr6.dao.lectors;

import edu.Sim3Lr6.entity.Discipline;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Slf4j
@Repository
public class DisciplineDAOImpl implements DisciplineDAO {

    private final EntityManager entityManager;
    @Autowired
    public DisciplineDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public List<Discipline> getAllDiscipline() {

        Query query = entityManager.createQuery("from Discipline");
        List<Discipline> allDiscipline = query.getResultList();
        log.info("getAllDiscipline" + allDiscipline);
        if (allDiscipline.isEmpty()){
            log.error("ErrorTableIsEmpty!");
            return null;
        }

        log.info("SUCCESS");
        return allDiscipline;
    }

    @Override
    public Discipline saveDiscipline(Discipline discipline) {
        return entityManager.merge(discipline);
    }

    @Override
    public Discipline putDiscipline(Discipline discipline, int id) {
        discipline.setId(id);

        if (getDiscipline(id) != null) {
            return entityManager.merge(discipline);
        } else {
            log.info("SUCCESS");
            return null;
        }
    }

    @Override
    public Discipline getDiscipline(int id){
        Discipline discipline = entityManager.find(Discipline.class, id);
        if (discipline == null){
            log.error("ErrorThisStringDoesn'tExist!");
            return null;
        }
        log.info("SUCCESS");
        return discipline;
    }

    @Override
    public void deleteDiscipline(int id){
        getDiscipline(id);
        Query query = entityManager.createQuery("delete from Discipline where id=:disciplineId");
        query.setParameter("disciplineId", id);
        query.executeUpdate();
        log.info("SUCCESS");
    }
}
