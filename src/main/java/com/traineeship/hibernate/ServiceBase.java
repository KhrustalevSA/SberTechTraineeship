package com.traineeship.hibernate;

import com.traineeship.logger.LoggerNames;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.lang.reflect.Field;

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

    public void UpdateA(T value, Long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        transaction.commit();
        session.close();
    }

    @Override
    public boolean equals(Object value){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Field[] fieldsValue = value.getClass().getDeclaredFields();

        try {
            Field id = value.getClass().getDeclaredField("id");
            id.setAccessible(true);
            T value2 = session.get(clazz, (long) id.get(value));
            Field[] fieldsThis = value2.getClass().getDeclaredFields();
            for(int i=0; i < fieldsValue.length; i += 1){


                Field fieldThis = fieldsThis[i];
                Field fieldValue = fieldsValue[i];
                fieldThis.setAccessible(true);
                fieldValue.setAccessible(true);
                Object fieldThisValue = fieldThis.get(value2);
                Object fieldValueValue = fieldValue.get(value);

                if (fieldThisValue == fieldValueValue){
                    System.out.println(fieldThis.get(value2)+ " = " + fieldValue.get(value));
                } else {
                    System.out.println(fieldThis.get(value2)+ " != " + fieldValue.get(value) + " Don't done");
                }
            }


        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        session.close();
        return false;
    }



    @Override
    public boolean equals(T value1, Long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        T value2 = (T) session.get(clazz, id);

        if(value2.equals(value1)){
            session.close();
            return true;
        }

        session.close();
        return false;
    }

    public void Update(T value, Long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if(session.get(clazz, id) != null){
            if(session.get(clazz, id) != value){
                session.update(value);
                transaction.commit();
            } else {
                LOGGER.debug("Объекты одинаковы");
            }
        }


        session.close();
    }

    /*public void UpdateStudent(Student student){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if(session.get(Student.class, student.getId()) != null){
            if(!equals(student,session.get(Student.class, student.getId()))){
                session.update(student);
            } else {
                LOGGER.debug("Нечего изменять");
            }
        }

        transaction.commit();
        session.close();
    }*/



}
