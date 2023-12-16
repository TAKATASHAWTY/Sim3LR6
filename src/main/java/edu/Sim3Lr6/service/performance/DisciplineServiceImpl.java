package edu.Sim3Lr6.service.performance;

import edu.Sim3Lr6.dao.lectors.DisciplineDAO;
import edu.Sim3Lr6.entity.Discipline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    private DisciplineDAO disciplineDAO;

    @Override
    @Transactional
    public List<Discipline> getAllDiscipline() {
        return disciplineDAO.getAllDiscipline();
    }

    @Override
    @Transactional
    public Discipline getDiscipline(int id) {return disciplineDAO.getDiscipline(id);}

    @Override
    @Transactional
    public Discipline saveDiscipline(Discipline discipline){
        return disciplineDAO.saveDiscipline(discipline);
    }

    @Override
    @Transactional
    public Discipline putDiscipline(Discipline discipline, int id) {
        return disciplineDAO.putDiscipline(discipline,id);
    }

    @Override
    @Transactional
    public void deleteDiscipline(int id) {disciplineDAO.deleteDiscipline(id);}
}
