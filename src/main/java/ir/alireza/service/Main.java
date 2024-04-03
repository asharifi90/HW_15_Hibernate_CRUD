package ir.alireza.service;

import ir.alireza.model.Person;
import ir.alireza.model.Student;
import ir.alireza.model.Teacher;
import ir.alireza.repository.PersonRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws ParseException {



        //todo class Person

//        PersonService personService = new PersonService();
//
//        Person person = new Person( "", "", LocalDate.of(1990, 2, 19));
//
//        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//
//        Validator validator = validatorFactory.getValidator();
//
//        Set<ConstraintViolation<Person>> violations = validator.validate(person);
//
//        for (ConstraintViolation<Person> violation : violations) {
//            System.out.println(violation.getMessage());
//        }
//
//        personService.save(person);
//        personService.save(new Person("Soleiman", "Soleimani", LocalDate.of(1995,11,25)));
//        personService.save(new Person("Amin", "amini", LocalDate.of(1991, 12, 22)));

//        System.out.println(personService.findAll());

//        System.out.println(personService.findById(1L));

//        personService.delete(3L);

//        Person person = personService.findById(4L);
//        person.setName("Ali");
//        person.setLastName("Ahmadi");
//        personService.update(person);

//        personService.signUp();

        // todo class Student

//        StudentService studentService = new StudentService();

//        studentService.save(new Student("lale", "emadi", LocalDate.of(2000,3,4), 123456, "Literature", 2024));

//        System.out.println(studentService.findAll());

//        System.out.println(studentService.findById(9L));

//        studentService.delete(9L);

//        Student student = studentService.findById(10L);
//        student.setBirthDate(LocalDate.of(1995, 2, 14));
//        student.setName("davood");
//        student.setLastName("davoodi");
//        studentService.update(student);

//        studentService.signUp();

        // todo class Teacher

//        TeacherService teacherService = new TeacherService();

//        teacherService.save(new Teacher("rana", "roohi", LocalDate.of(2000, 4, 12),
//                45767, "doctora", rank.OSTAD, 20000000 ));

//        teacherService.save(new Teacher("raha", "roohi", LocalDate.of(2001, 4, 12),
//                56434, "Master", rank.OSTADYAR, 20000000 ));

//        System.out.println(teacherService.findAll());

//        System.out.println(teacherService.findById(12L));

//        teacherService.delete(12L);

//        Teacher teacher = teacherService.findById(13L);
//        teacher.setSalary(30000000);
//        teacher.setLastName("nemati");
//        teacherService.update(teacher);

//        teacherService.signUp();

    }
}
