package com.traineeship.student;


import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {
    private final String dateBaseDriver;

    public StudentServiceImpl(String dateBaseDriver) {
        this.dateBaseDriver = dateBaseDriver;
    }

    public void add(Student student) {
        //TODO
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student name");
        student.setName(scanner.nextLine());
        System.out.println("Enter student group");
        student.setGroup(scanner.nextLong());
        System.out.println("Enter student birthdate ( Year, month, day )");

        Calendar birthDate = new GregorianCalendar();
        birthDate.set(Calendar.YEAR, scanner.nextInt());
        birthDate.set(Calendar.MONTH, scanner.nextInt());
        birthDate.set(Calendar.DAY_OF_MONTH, scanner.nextInt());
        student.setBirthDate(birthDate);
         */

        try{
            Class.forName(dateBaseDriver);
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test");
            Statement statement = connection.createStatement();

            String SQL = "INSERT INTO STUDENTS(student_name, group_namber, birthday) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setLong(2,student.getGroup());

            java.util.Date utilDate = student.getBirthDate().getTime();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            preparedStatement.setDate(3, sqlDate);

            preparedStatement.execute();

            SQL =  "SELECT * FROM STUDENTS";
            ResultSet resultSet = statement.executeQuery(SQL);

            /*
            while (resultSet.next()) {


                String initials = resultSet.getString(1);
                String group_name = resultSet.getString(2);
                String birthday = resultSet.getString(3);

                System.out.println("initials: " + initials);
                System.out.println("group_name: " + group_name);
                System.out.println("birthday: " + birthday);
                System.out.println("===================\n");
            }
             */

        }catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }

    }

    public Student get(String name)  {
        //TODO
        try{
            Student student = new StudentImpl();
            Class.forName(dateBaseDriver);
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test");
            Statement statement = connection.createStatement();

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
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }


        return null;
    }

    public String getDateBaseDriver() {
        return dateBaseDriver;
    }
}
