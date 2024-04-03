package ir.alireza.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Parent_class", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name can not be empty")
    private String name;

    @NotNull(message = "Lastname can not be empty")
    private String lastName;

    @Past(message = "Your birthdate can not be in the future")
    private LocalDate birthDate;

    public Person(String name, String lastName, LocalDate birthDate){
        this.name =  name;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }


    public Person(Long id) {
        this.id = id;
    }
}
