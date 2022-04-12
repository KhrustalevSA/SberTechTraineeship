package com.traineeship;


import com.traineeship.hibernate.ServiceBase;
import com.traineeship.logger.LoggerNames;
import com.traineeship.project.*;
import com.traineeship.projectInterfaces.Faculty;
import com.traineeship.projectInterfaces.Student;
import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class App {
    private static final Logger LOGGER = Logger.getLogger(LoggerNames.DATABASE.name());
    //private static final ServiceBase studentService = new StudentServiceImpl();
    private static final ServiceBase SERVICE = new FacultyServiceImpl();
    //private static final ServiceBase yearService = new YearServiceImpl();

    public static void main(String[] args) {

        try {
            Calendar student_birthDate = new GregorianCalendar();
            student_birthDate.set(Calendar.YEAR, 2001);
            student_birthDate.set(Calendar.MONTH, 03);
            student_birthDate.set(Calendar.DAY_OF_MONTH,04);
            Student student = new StudentImpl(3L,"Иван",40931L,student_birthDate);

            Faculty faculty = new FacultyImpl(1L,"IMEIKN",4L);


            SERVICE.add(student);
            SERVICE.add(faculty);



        } catch (Exception e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            LOGGER.error("Error");
        }


    }
}

// Проект на MySql, тесты на H2, Code Style, logger.debug() - множественная информация