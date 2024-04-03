package ir.alireza.service;

import ir.alireza.model.Person;
import ir.alireza.repository.PersonRepository;
import jakarta.validation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.ErrorManager;

public class PersonService {

    private final PersonRepository personRepository = new PersonRepository();

    public void save(Person person){
        personRepository.save(person);
    }

    public Person findById(Long id){
        return personRepository.findById(id);
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public void delete(Long id){
        Person person = new Person(id);
        personRepository.delete(person);
    }

    public void update(Person person){
        personRepository.update(person);
    }

    public void signUp() throws ParseException {

        Person person = new Person();
        Scanner input = new Scanner(System.in);

        System.out.println("Please Enter your name");
        person.setName(input.nextLine());

        System.out.println("Please enter your lastName");
        person.setLastName(input.nextLine());

        System.out.println("Please enter your date of birth (YYYY/MM/DD)");
        String date =  input.nextLine();

        Date birthdate = new SimpleDateFormat("yyyy/MM/dd").parse(date);
        LocalDate birthDate = birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        person.setBirthDate(birthDate);

        personRepository.save(person);

    }

}
