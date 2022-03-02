package com.traineeship;

import com.traineeship.config.ApplicationConfig;
import com.traineeship.config.ConfigFactory;
import com.traineeship.config.DataBaseConfig;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PropertyConfigurator.configure("src/main/resources/app.properties");
        final String db_driver = "org.h2.Driver";
        final String url = "jdbc:h2:mem:test";

        try{
            Class.forName(db_driver);
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test");
            Statement statement = connection.createStatement();

            File file = new File("D:\\Apps\\IntelliJ IDEA 2021.2.2\\Projects\\jdbcapi\\src\\main\\resources\\Запросы.txt");
            Scanner sc = new Scanner(file);


            System.out.println(ConfigFactory.getConfig(DataBaseConfig.class).getProperty("db_driver"));
            //while(sc.hasNext()) {
            //    System.out.println(sc.next());
            // }


          //  String SQL = sc.toString();
          //  SQL = SQL.replace("\n", "");
          //  PreparedStatement ps = null;
          // ps = connection.prepareStatement(SQL);
          //  ps.setString(1, "taplejung");

          //  statement.executeUpdate(SQL);
          //  System.out.println("Done");

          // ApplicationConfig properties_operations = new ApplicationConfig();

          // String driver = configFactory.getClass();
          //         properties_operations.get_property("db_driver");

          // System.out.println(driver);


        }catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
