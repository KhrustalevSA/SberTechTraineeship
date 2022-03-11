package com.traineeship;


import com.traineeship.project.StudentImpl;
import com.traineeship.projectInterfaces.Student;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class App {
    public static void main(String[] args) {


        try{
            long id = 1;
            String student_name = "Иван";
            long student_group = 90301;
            Calendar student_birthDate = new GregorianCalendar();
            student_birthDate.set(Calendar.YEAR, 1998);
            student_birthDate.set(Calendar.MONTH, 11);
            student_birthDate.set(Calendar.DAY_OF_MONTH,26);

            Student student1 = new StudentImpl(id,student_name,student_group,student_birthDate);

             id = 2;
             student_name = "Sergey";
             student_group = 90302;

            student_birthDate.set(Calendar.YEAR, 1998);
            student_birthDate.set(Calendar.MONTH, 11);
            student_birthDate.set(Calendar.DAY_OF_MONTH,26);

            Student student2 = new StudentImpl(id,student_name,student_group,student_birthDate);


             id = 3;
             student_name = "Иван";
             student_group = 90301;

            student_birthDate.set(Calendar.YEAR, 1998);
            student_birthDate.set(Calendar.MONTH, 11);
            student_birthDate.set(Calendar.DAY_OF_MONTH,26);

            Student student3 = new StudentImpl(id,student_name,student_group,student_birthDate);

            if(student1.equals(student1)) System.out.println("Object1");
            if(student1.equals(student2)) System.out.println("Object2");
            if(student1.equals(student3)) System.out.println("Object3");

            if(student1.equals(student1,student1)) System.out.println("Student1 Student1");
            if(student1.equals(student1,student2)) System.out.println("Student1 Student2");
            if(student1.equals(student1,student3)) System.out.println("Student1 Student3");






        }catch (Exception e){

        }


    }
}
