package com.traineeship.project;

import com.traineeship.logger.LoggerNames;
import com.traineeship.projectInterfaces.Student;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Класс для создания объекта Студент и получения его полей
 * @author Khrustalev-sa
 * @since 27.02.2022
 */
@Entity
@Table(name = "STUDENTS")
public class StudentImpl implements Student {
    private static final Logger LOGGER = Logger.getLogger(LoggerNames.CORE.name());
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "student_name")
    private String name;

    @Column(name = "group_namber")
    private Long group;

    @Column(name = "birthday")
    private Calendar birthDate;



    /**
     * Конструктор - Создание объекта StudentImpl
     * @see StudentImpl#StudentImpl(Long,String,Long,Calendar)
     */
    public StudentImpl() {
        LOGGER.debug("Создался пустой объект Студент");
    }

    /**
     * Создание объекта StudentImpl с заданными значениями полей
     * @param name - имя студента
     * @param group - номер группы студента
     * @param birthDate - Дата рождения студента
     * @see StudentImpl#StudentImpl()
     */
    public StudentImpl(Long id,String name, Long group, Calendar birthDate) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.birthDate = birthDate;
        LOGGER.info("Создан студент: " + name + " " + group + " " + birthDate);
    }



    /**
     * Функция получения имени студента
     * @return name
     */
    public String getName() {
        LOGGER.info("Получили имя: " + name);
        return name;
    }

    /**
     * Функция определения имени студента
     * @param name - имя студента
     */
    public void setName(String name) {
        this.name = name;
        LOGGER.info("Установили имя: " + this.name);
    }

    /**
     * Функция получения номера группы студента
     * @return group
     */
    public Long getGroup() {
        LOGGER.info("Получили группу: " + group);
        return group;
    }

    /**
     * Функция определения номера группы студента
     * @param group - номер группы сдудента
     */
    public void setGroup(Long group) {
        this.group = group;
        LOGGER.info("Установили группу: " + this.group);
    }

    /**
     * Функция получения даты рождения студента
     * @return birthDate
     */
    public Calendar getBirthDate() {

        return birthDate;
    }



    /**
     * Функция определения даты рождения студента
     * @param birthDate - дата рождения студента
     */
    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
        LOGGER.info("Установили дату рождения: " + this.birthDate);
    }


    @Override
    public boolean equals(Object object){
        if(object instanceof StudentImpl ) {
            if (this == object){
                return true;
            } else {
                StudentImpl val = (StudentImpl) object;
                return compare(this.getId(),val.getId()) &&
                       compare(this.getName(),val.getName()) &&
                       compare(this.getGroup(), val.getGroup()) &&
                       compare(this.getBirthDate(), val.getBirthDate());
            }
        } else {
            return false;
        }


    }
    private boolean compare(Object obj1, Object obj2){
        if(obj1 == null && obj2 == null){
            return true;
        } else if(obj1 != null && obj2 != null){
            return obj1.equals(obj2);
        } else {
            return false;
        }
    }


    /**
     * Функция получения имени студента
     * @return name
     */
    public Long getId() {
        LOGGER.info("Получили дату рождения: " + birthDate);
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        LOGGER.info("Установили id: " + this.id);
    }

}
