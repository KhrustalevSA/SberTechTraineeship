package com.traineeship.project;

import com.traineeship.hibernate.ServiceBase;
import com.traineeship.logger.LoggerNames;
import com.traineeship.projectInterfaces.Student;
import com.traineeship.projectInterfaces.StudentService;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * Класс для добавления или получения объекта Студент
 * @author Khrustalev-sa
 * @since 27.02.2022
 */
public class StudentServiceImpl extends ServiceBase<StudentImpl> {
    private final String dateBaseDriver = "a";
    private static final Logger LOGGER = Logger.getLogger(LoggerNames.CORE.name());

    /**
     * Конструктор - Создание объекта StudentServiceImpl
     */
    public StudentServiceImpl() {
        super(StudentImpl.class);
    }

    /**
     * Функция добавления нового студента
     * @param student - объект класса StudentImpl
     * @exception ClassNotFoundException - ошибка нахождения драйвера базы данных
     * @exception SQLException - ошибка SQL кода
     */
    public void addOld(Student student) {

        try{
            LOGGER.info("Программа подключает драйвер Базы данных:"+ dateBaseDriver + " и подключается по URL: jdbc:h2:mem:test");
            Class.forName(dateBaseDriver);
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test");
            Statement statement = connection.createStatement();
            java.util.Date utilDate = student.getBirthDate().getTime();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());



            LOGGER.info("Добавление в таблицу STUDENTS нового студента с параметрами: \nИмя студента: " + student.getName()
                            + "\nНомер группы студента: " + student.getGroup() + "\nДата рождения студента: " + sqlDate);
            String SQL = "INSERT INTO STUDENTS(student_name, group_namber, birthday) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setLong(2,student.getGroup());


            preparedStatement.setDate(3, sqlDate);

            preparedStatement.execute();

            LOGGER.info("Вывод информации из таблицы STUDENTS");
            SQL =  "SELECT * FROM STUDENTS";
            ResultSet resultSet = statement.executeQuery(SQL);


        }catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            LOGGER.debug("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            LOGGER.error("Ошибка SQL !");
        }

    }

    /**
     * Функция получения Объекта Student из базы данных
     * @return student - объект класса StudentImpl
     * @param name  - имя студента
     * @exception ClassNotFoundException - ошибка нахождения драйвера базы данных
     * @exception SQLException - ошибка SQL кода
     */
    public Student getOld(String name)  {
        //TODO
        try{
            LOGGER.info("Программа подключает драйвер Базы данных:"+ dateBaseDriver + " и подключается по URL: jdbc:h2:mem:test");
            Student student = new StudentImpl();
            Class.forName(dateBaseDriver);
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test");
            Statement statement = connection.createStatement();

            LOGGER.info("Заполнение resultSet");
            String SQL =  "SELECT * FROM STUDENTS";
            ResultSet resultSet = statement.executeQuery(SQL);


            while (resultSet.next()){

                /*
                String  initials = resultSet.getString(1);
                String  group_name = resultSet.getString(2);
                String  birthday = resultSet.getString(3);

                System.out.println("initials: " + initials);
                System.out.println("group_name: " + group_name);
                System.out.println("birthday: " + birthday);
                System.out.println("===================\n");
                 */

                LOGGER.info("Получение студента");
                if (Objects.equals(resultSet.getString(1), name)){

                    student.setName(resultSet.getString(1));
                    student.setGroup(resultSet.getLong(2));

                    Calendar birthdate = new GregorianCalendar();
                    birthdate.setTime(resultSet.getDate(3));
                    student.setBirthDate(birthdate);
                    return student;
                }

            }

        }catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            LOGGER.debug("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            LOGGER.error("Ошибка SQL !");
        }


        return null;
    }

    /**
     * Функция получения драйвера базы данных
     * @return dateBaseDriver
     */
    public String getDateBaseDriver() {
        LOGGER.info("Получение драйвера быза данных: " + dateBaseDriver);
        return dateBaseDriver;
    }
}
