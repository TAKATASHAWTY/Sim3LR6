package edu.Sim3Lr6.controller;

import edu.Sim3Lr6.entity.Discipline;
import edu.Sim3Lr6.service.performance.DisciplineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disc")
@Slf4j
public class DesciplineContoller {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/discipline")
    public List<Discipline> showAllDiscipline(){
        List<Discipline> allDiscipline = disciplineService.getAllDiscipline();
        return allDiscipline;
    }

    @GetMapping("/discipline/{id}")
    public Discipline getDiscipline(@PathVariable("id") int id) {return disciplineService.getDiscipline(id);}

    @PostMapping("/discipline")
    public Discipline saveDiscipline(@RequestBody Discipline discipline) {return disciplineService.saveDiscipline(discipline);}

    @PutMapping("/discipline")
    public Discipline updateDiscipline(@RequestBody Discipline discipline){
        disciplineService.saveDiscipline(discipline);
        return discipline;
    }

    @DeleteMapping("/discipline/{id}")
    public void deleteDiscipline(@PathVariable("id") int id){disciplineService.deleteDiscipline(id);}
}
