package ir.alireza.repository;

import ir.alireza.connection.SessionFactorySingleton;
import ir.alireza.model.Person;
import ir.alireza.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;

public class StudentRepository {

    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public void save(Student student){

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(student);
        transaction.commit();
        session.close();

    }

    public void update(Student student){

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(student);
        transaction.commit();
        session.close();

    }

    public Student findById(Long id){

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        transaction.commit();
        session.close();
        return student;
    }

    public List<Student> findAll(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Student";
        Query<Student> fromStudent = session.createQuery(hql, Student.class);
        List<Student> studentList =fromStudent.list();
        transaction.commit();
        session.close();
        return studentList;
    }

    public void delete(Student student){
        Session session =  sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(student);
        transaction.commit();
        session.close();
    }
}
