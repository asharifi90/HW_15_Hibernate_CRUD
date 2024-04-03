package ir.alireza.service;

import ir.alireza.model.Teacher;
import ir.alireza.repository.TeacherRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TeacherService {

    TeacherRepository teacherRepository =  new TeacherRepository();

    public void save(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void update(Teacher teacher){
        teacherRepository.update(teacher);
    }

    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

    public Teacher findById(Long id){
        return teacherRepository.findById(id);
    }

    public void delete(Long id){
        Teacher teacher = teacherRepository.findById(id);
        teacherRepository.delete(teacher);
    }



    public void signUp() throws ParseException {

        Teacher teacher = new Teacher();
        Scanner input = new Scanner(System.in);

        System.out.println("Please Enter your name");
        teacher.setName(input.nextLine());

        System.out.println("Please enter your lastName");
        teacher.setLastName(input.nextLine());

        System.out.println("Please enter your date of birth (YYYY/MM/DD)");
        String date =  input.nextLine();

        Date birthdate = new SimpleDateFormat("yyyy/MM/dd").parse(date);
        LocalDate birthDate = birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        teacher.setBirthDate(birthDate);

        System.out.println("Please enter your teacher code");
        teacher.setTeacherCode(input.nextInt());
        input.nextLine();

        System.out.println("Please enter your study degree");
        teacher.setStudyDegree(input.nextLine());

        System.out.println("Please Enter your ProfessorShip(OSTAD, OSTADYAR, OSTADTAMAM)");
        String professorship = input.nextLine();

        teacher.setProfessorship(rank.valueOf(professorship));

        System.out.println("Please enter your salary");
        teacher.setSalary(input.nextInt());
        input.nextLine();

        teacherRepository.save(teacher);

    }
}
