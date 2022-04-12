package com.traineeship.serviceTest;


import com.traineeship.hibernate.ServiceBase;
import com.traineeship.project.*;
import com.traineeship.projectInterfaces.Faculty;
import com.traineeship.projectInterfaces.Student;
import com.traineeship.projectInterfaces.Year;
import org.junit.Assert;
import org.junit.Test;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class ServiceTest {

    private static final String db_driver = "org.h2.Driver";
    private static ServiceBase facultyService = new FacultyServiceImpl();
    private static ServiceBase studentService = new StudentServiceImpl();
    private static ServiceBase yearService = new YearServiceImpl();


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
    public void testAddStudent() {
        long id = 1;
        String student_name = "Иван";
        long student_group = 90301;
        Calendar student_birthDate = new GregorianCalendar();
        student_birthDate.set(Calendar.YEAR, 1998);
        student_birthDate.set(Calendar.MONTH, 11);
        student_birthDate.set(Calendar.DAY_OF_MONTH,26);

        Student student = new StudentImpl(id,student_name,student_group,student_birthDate);
        studentService.add(student);
        student.setId(2L);
        studentService.add(student);

        studentService.equals(student);
       Assert.assertTrue(String.valueOf(true), student.equals(studentService.get(student,student.getId()))); // service.equals(student, (Student) service.get(Student.class,1L))

    }

    @Test
    public void testAddFaculty() {
        long id = 1;
        String faculty_name = "ИИВТ";
        long yearsQuantity = 4;

        Faculty faculty = new FacultyImpl(id,faculty_name,yearsQuantity);
        facultyService.add(faculty);
        facultyService.get(faculty,faculty.getId());

        Assert.assertTrue(String.valueOf(true), faculty.equals(facultyService.get(faculty,faculty.getId()))); // service.equals(student, (Student) service.get(Student.class,1L))

    }

    @Test
    public void testGetStudent() {
        long id = 1;
        String student_name = "Сергей";
        long student_group = 40931;
        Calendar student_birthDate = new GregorianCalendar();
        student_birthDate.set(Calendar.YEAR, 2001);
        student_birthDate.set(Calendar.MONTH, 03);
        student_birthDate.set(Calendar.DAY_OF_MONTH,04);

        Student student = new StudentImpl(id,student_name,student_group,student_birthDate);
        studentService.add(student);
        studentService.get(student,student.getId());

        Assert.assertTrue(String.valueOf(true),student.equals(studentService.get(student,student.getId())));

    }

    @Test
    public void testGetFaculty() {
        long id = 1;
        String faculty_name = "ИИВТ";
        long yearsQuantity = 4;

        Faculty faculty = new FacultyImpl(id,faculty_name,yearsQuantity);
        facultyService.add(faculty);
        facultyService.get(faculty,faculty.getId());

        Assert.assertTrue(String.valueOf(true),faculty.equals(facultyService.get(faculty,faculty.getId())));

    }

    @Test
    public void testGetYear() {

        Long id = 1L;
        long startYear = 2009L;
        Long yearNow = 2010L;
        Long studentsQuantity = 21L;

        Year year = new YearImpl(id,startYear,yearNow,studentsQuantity);
        yearService.add(year);
        yearService.get(year,year.getId());

        Assert.assertTrue(String.valueOf(true),year.equals(yearService.get(year,year.getId())));

    }



    @Test
    public void testAddAndUpdateStudent() {
        long id = 1;
        String student_name = "Иван";
        long student_group = 90301;
        Calendar student_birthDate = new GregorianCalendar();
        student_birthDate.set(Calendar.YEAR, 1998);
        student_birthDate.set(Calendar.MONTH, 11);
        student_birthDate.set(Calendar.DAY_OF_MONTH,26);
        Student student1 = new StudentImpl(id,student_name,student_group,student_birthDate);
        id = 2;
        student_name = "Артем";
        student_group = 90302;
        student_birthDate.set(Calendar.YEAR, 1999);
        student_birthDate.set(Calendar.MONTH, 4);
        student_birthDate.set(Calendar.DAY_OF_MONTH,13);
        Student student2 = new StudentImpl(id,student_name,student_group,student_birthDate);


        studentService.addOrUpdate(student1);
        studentService.addOrUpdate(student2);
        student_name = "Игорь";
        student1.setName(student_name);
        studentService.addOrUpdate(student1);

        Assert.assertTrue(String.valueOf(true), Objects.equals(student1.getName(), student_name)); //service.equals(student1,student2)

    }

    @Test
    public void testUpdateStudent() {
        long id = 1;
        String student_name = "Иван";
        long student_group = 90301;
        Calendar student_birthDate = new GregorianCalendar();
        student_birthDate.set(Calendar.YEAR, 1998);
        student_birthDate.set(Calendar.MONTH, 11);
        student_birthDate.set(Calendar.DAY_OF_MONTH,26);
        Student student1 = new StudentImpl(id,student_name,student_group,student_birthDate);



        studentService.add(student1);
        student_name = "Игорь";
        student1.setName(student_name);
        studentService.Update(student1);

        Assert.assertTrue(String.valueOf(true), Objects.equals(student1.getName(), student_name));

    }

    @Test
    public void testDeleteStudent() {
        long id = 1;
        String student_name = "Иван";
        long student_group = 90301;
        Calendar student_birthDate = new GregorianCalendar();
        student_birthDate.set(Calendar.YEAR, 1998);
        student_birthDate.set(Calendar.MONTH, 11);
        student_birthDate.set(Calendar.DAY_OF_MONTH,26);
        Student student1 = new StudentImpl(id,student_name,student_group,student_birthDate);



        studentService.add(student1);

        studentService.delete(student1,student1.getId());

        Assert.assertTrue(String.valueOf(true), studentService.get(student1,student1.getId()) == null);

    }

}
// Попробовать перенести нотации hibernate (@id,@Table...) на интерфейс ( - )
// Метод addOrUpdate(Проверка на наличие если есть - изменяет), delete\remove, find(id), add id in Table(PK), find по критериям, find<T value>, Лог (RunTimeExc), Method findAll(select * from)
// метод update(value): 1) Проверить наличие в бд, 2) Если есть сравнить, 3) Если отличаются: Заменить и обновить (id - не меняется)
// Почистить

//Добавить 2 таблицы: 1)Курс ( ) 2)Факультет (), доработать связки таблиц от Студента, сделать сервисы
//Студент: добавить регистрация на факультет и на курс при добавлении @OneToOne @OneToMany и др


// как развернуть postgres/MySQL
// модификаторы доступа, типы переменных(+ базовые классы), Коллекции(понимание), умение писать потоки, и др, (тернарн), синтаксис, SQl
// docer