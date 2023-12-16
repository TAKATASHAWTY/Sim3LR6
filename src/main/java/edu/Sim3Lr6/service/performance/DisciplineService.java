package edu.Sim3Lr6.service.performance;

import edu.Sim3Lr6.entity.Discipline;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DisciplineService {
    List<Discipline> getAllDiscipline();
    Discipline saveDiscipline(Discipline lector);
    Discipline getDiscipline(int id);
    Discipline putDiscipline(Discipline lector, int id);
    void deleteDiscipline(int id);
}
