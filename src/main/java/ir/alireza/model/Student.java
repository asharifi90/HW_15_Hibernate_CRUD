package ir.alireza.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@NoArgsConstructor
@Setter
@Getter

@Entity
@DiscriminatorValue("Student")
public class Student extends Person{

    private Integer studentCode;
    private String studyField;
    private Integer entryYear;


    public Student(String name, String lastname, LocalDate birthDate,
                   Integer studentCode, String studyField, Integer entryYear){

        super(name, lastname, birthDate);
        this.studentCode = studentCode;
        this.studyField = studyField;
        this.entryYear = entryYear;


    }

    public Student(Long id){
        super(id);
    }

}
