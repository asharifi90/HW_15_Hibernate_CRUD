package ir.alireza.service;

import ir.alireza.model.Person;
import ir.alireza.model.Student;
import ir.alireza.repository.PersonRepository;
import ir.alireza.repository.StudentRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StudentService {

    StudentRepository studentRepository = new StudentRepository();

    public void save(Student student){
        studentRepository.save(student);
    }

    public void update(Student student){
        studentRepository.update(student);
    }

    public Student findById(Long id){
       return studentRepository.findById(id);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public void delete(Long id){
        Student student = new Student(id);
         studentRepository.delete(student);
    }

    public void signUp() throws ParseException {

        Student student = new Student();
        Scanner input = new Scanner(System.in);

        System.out.println("Please Enter your name");
        student.setName(input.nextLine());

        System.out.println("Please enter your lastName");
        student.setLastName(input.nextLine());

        System.out.println("Please enter your date of birth (YYYY/MM/DD)");
        String date =  input.nextLine();

        Date birthdate = new SimpleDateFormat("yyyy/MM/dd").parse(date);
        LocalDate birthDate = birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        student.setBirthDate(birthDate);

        System.out.println("Please enter your student code");
        student.setStudentCode(input.nextInt());
        input.nextLine();

        System.out.println("Please enter your studyField");
        student.setStudyField(input.nextLine());

        System.out.println("Please enter your entryYear");
        student.setEntryYear(input.nextInt());
        input.nextLine();

        studentRepository.save(student);
    }




}
