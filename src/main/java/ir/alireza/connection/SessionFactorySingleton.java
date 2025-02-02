package ir.alireza.connection;

import ir.alireza.model.Person;
import ir.alireza.model.Student;
import ir.alireza.model.Teacher;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {

    private SessionFactorySingleton(){

    }


    private static class LazyHolder{

        static SessionFactory INSTANCE;

        static {
            var registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            INSTANCE = new MetadataSources(registry)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Person.class)
                    .addAnnotatedClass(Teacher.class)
                    .buildMetadata()
                    .buildSessionFactory();

        }
    }

    public static SessionFactory getInstance(){
        return LazyHolder.INSTANCE;
    }

}
