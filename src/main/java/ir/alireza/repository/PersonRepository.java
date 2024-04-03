package ir.alireza.repository;

import ir.alireza.connection.SessionFactorySingleton;
import ir.alireza.model.Person;
import jakarta.persistence.Id;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;

public class PersonRepository {

    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public void save(Person person){

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(person);
        transaction.commit();
        session.close();

    }

    public void update(Person person){

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(person);
        transaction.commit();
        session.close();
    }

    public Person findById(Long id){

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person person = session.get(Person.class, id);
        transaction.commit();
        session.close();
        return person;
    }

    public List<Person> findAll(){
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        String hql = "from Person";
        Query<Person> fromPerson = session.createQuery(hql, Person.class);
        List<Person> personList = fromPerson.list();
        transaction.commit();
        session.close();
        return personList;
    }

    public void delete(Person person){
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        session.remove(person);
        transaction.commit();
        session.close();
    }

}
