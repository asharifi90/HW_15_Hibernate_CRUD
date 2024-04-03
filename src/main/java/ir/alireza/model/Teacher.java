package ir.alireza.model;

import ir.alireza.service.rank;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

@Entity
@DiscriminatorValue("Teacher")
public class Teacher extends Person{

    private Integer teacherCode;
    private String studyDegree;

    @Enumerated(EnumType.STRING)
    private rank professorship;
    private Integer salary;

    public Teacher(String name, String lastName, LocalDate birthDate,
                   Integer teacherCode, String studyDegree, rank professorship, Integer salary){

        super(name, lastName, birthDate);
        this.teacherCode = teacherCode;
        this.studyDegree = studyDegree;
        this.professorship = professorship;
        this.salary = salary;
    }

    public Teacher(Long id){
        super(id);
    }
}
