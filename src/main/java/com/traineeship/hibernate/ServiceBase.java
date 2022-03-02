package com.traineeship.hibernate;

import com.traineeship.project.StudentImpl;
import com.traineeship.projectInterfaces.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public abstract class ServiceBase<T> implements Service<T> {

    private final SessionFactory sessionFactory;
    private final Class<T> clazz;
    protected ServiceBase(Class<T> clazz){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        this.clazz = clazz;
    }

    @Override
    public void add(T value){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(value);
        transaction.commit();
        session.close();
    }

    @Override
    public T find(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        T value = session.find(clazz, id);
        session.close();
        return value;
    }
}
