package com.traineeship.hibernate;

import com.traineeship.logger.LoggerNames;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public abstract class ServiceBase<T> implements Service<T> {

    private static final Logger LOGGER = Logger.getLogger(LoggerNames.CORE.name());
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
    public T get(T value, Long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if (session.get(clazz,id) != null){
            T val = session.get(clazz,id);
            session.close();
           return val;
        }

        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public T find(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        T value = session.find(clazz, id);
        session.close();
        return value;
    }

    @Override
    public void addOrUpdate(T value){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(value);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(T value, Long id){

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(value);
        transaction.commit();
        session.close();

    }


    public void Update(T value){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(value);
        transaction.commit();
        session.close();
    }





}
