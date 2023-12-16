package edu.Sim3Lr6.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "DISCIPLINE")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "discipline")
    private String discipline;

    @Column(name = "description")
    private String description;

    @Column(name = "grade")
    private int grade;

    public Discipline(){}
    public Discipline(String lectorname, String lectorsurname, int grade) {
        this.discipline = discipline;
        this.description = description;
        this.grade = grade;
    }
}
