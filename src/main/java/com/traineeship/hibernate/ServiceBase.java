package com.traineeship.hibernate;

import com.traineeship.logger.LoggerNames;
import com.traineeship.projectInterfaces.Student;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.Objects;

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
        if (value != null){
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

    public void Update(T value, Long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        transaction.commit();
        session.close();
    }

    @Override
    public boolean equalsObjects(T value1, Long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        T value2 = (T) session.get(clazz, id);
        String[] columnNames = (String[]) sessionFactory.getClassMetadata(clazz).getPropertyValues(value1);

        for (int i = 0; i <= columnNames.length; i++){
            if(true);
        }

        session.close();
        return false;
    }

    @Override
    public boolean equalsObjectsFunc(T value1, T value2){
        String[] columnNames = sessionFactory.getClassMetadata(clazz).getPropertyNames();
        String idName = sessionFactory.getClassMetadata(clazz).getIdentifierPropertyName();
        // ----> clazz.getMethods()
        return false;
    }

    public void UpdateStudent(Student student){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if(session.get(Student.class, student.getId()) != null){
            if(!equalsStudents(student,session.get(Student.class, student.getId()))){
                session.update(student);
            } else {
                LOGGER.debug("Нечего изменять");
            }
        }

        transaction.commit();
        session.close();
    }


    @Override
    public boolean equalsStudents(Student student1, Student student2){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if(Objects.equals(student1.getId(),student2.getId()) &&
                Objects.equals(student1.getName(),student2.getName()) &&
                Objects.equals(student1.getGroup(),student2.getGroup()) &&
                Objects.equals(student1.getBirthDate(),student2.getBirthDate()))
        {
            session.close();
            return true;
        }
        session.close();
        return false;
    }

}
