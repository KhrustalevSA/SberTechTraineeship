package com.traineeship.studentTest;


import com.traineeship.hibernate.ServiceBase;
import com.traineeship.projectInterfaces.Student;
import com.traineeship.project.StudentImpl;
import com.traineeship.projectInterfaces.StudentService;
import com.traineeship.project.StudentServiceImpl;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class StudentServiceTest {

    private static final String db_driver = "org.h2.Driver";
    private static ServiceBase service = new StudentServiceImpl();


    public static void init() {
        try{
            Class.forName(db_driver);
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test");
            Statement statement = null;
            statement = connection.createStatement();
            String SQL = "CREATE TABLE IF NOT EXISTS STUDENTS " +
                    "(id numeric Primary Key not null, " +
                    "(student_name VARCHAR(50), " +
                    " group_namber INTEGER(6), " +
                    " birthday DATE (8)) ";
            statement.executeUpdate(SQL);

            SQL =  "INSERT INTO STUDENTS VALUES ('Сергей', '40931', '2001-03-04')";
            statement.executeUpdate(SQL);




        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }

    }

    @Test
    public void testGetStudent() {
        String student_name = "Сергей";
        long student_group = 40931;
        Calendar student_birthDate = new GregorianCalendar();
        student_birthDate.set(Calendar.YEAR, 2001);
        student_birthDate.set(Calendar.MONTH, 03);
        student_birthDate.set(Calendar.DAY_OF_MONTH,04);

        Student student = new StudentImpl(student_name,student_group,student_birthDate);
        //service.add(student);

        //Assert.assertSame(student,service.get(student_name));
        //Assert.assertTrue(Objects.equals(student.getName(),service.get(student_name).getName()));

    }

    @Test
    public void testAddStudent() {
        long id = 1;
        String student_name = "Иван";
        long student_group = 90301;
        Calendar student_birthDate = new GregorianCalendar();
        student_birthDate.set(Calendar.YEAR, 1998);
        student_birthDate.set(Calendar.MONTH, 11);
        student_birthDate.set(Calendar.DAY_OF_MONTH,26);

        Student student = new StudentImpl(student_name,student_group,student_birthDate);
        service.add(student);

        //Assert.assertEquals(student,service.get(student_name));
        Assert.assertTrue( Objects.equals(student.getName(), service.find(1)));

    }
}
// Попробовать перенести нотации hibernate (@id,@Table...) на интерфейс
// Метод addOrUpdate(Проверка на наличие если есть - изменяет), delete\remove, find(id), add id in Table(PK), find по критериям, find<T value>, Лог (RunTimeExc), Method findAll(select * from)
// метод update(value): 1) Проверить наличие в бд, 2) Если есть сравнить, 3) Если отличаются: Заменить и обновить (id - не меняется)
// Почистить