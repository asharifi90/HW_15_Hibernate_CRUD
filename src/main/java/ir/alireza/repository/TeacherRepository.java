package ir.alireza.repository;

import ir.alireza.connection.SessionFactorySingleton;
import ir.alireza.model.Person;
import ir.alireza.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TeacherRepository {

    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public void save(Teacher teacher){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(teacher);
        transaction.commit();
        session.close();
    }

    public void update(Teacher teacher){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(teacher);
        transaction.commit();
        session.close();
    }

    public Teacher findById(Long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Teacher teacher = session.get(Teacher.class, id);
        transaction.commit();
        session.close();
        return teacher;
    }

    public List<Teacher> findAll(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Teacher";
        Query<Teacher> fromTeacher = session.createQuery(hql, Teacher.class);
        List<Teacher> teacherList = fromTeacher.list();
        transaction.commit();
        session.close();
        return teacherList;
    }

    public void delete(Teacher teacher){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(teacher);
        transaction.commit();
        session.close();
    }

}
