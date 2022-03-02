package com.traineeship.project;

import com.traineeship.logger.LoggerNames;
import com.traineeship.projectInterfaces.Student;
import org.apache.log4j.Logger;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    private int id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "group_namber")
    private Long group;

    @Column(name = "birthday")
    private Calendar birthDate;

    /**
     * Конструктор - Создание объекта StudentImpl
     * @see StudentImpl#StudentImpl(String,Long,Calendar)
     */
    public StudentImpl() {
        LOGGER.info("Создался пустой объект Студент");
    }

    /**
     * Создание объекта StudentImpl с заданными значениями полей
     * @param name - имя студента
     * @param group - номер группы студента
     * @param birthDate - Дата рождения студента
     * @see StudentImpl#StudentImpl()
     */
    public StudentImpl(String name, Long group, Calendar birthDate) {
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
        LOGGER.info("Установили имя: " + this.name);
        this.name = name;
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
        LOGGER.info("Установили группу: " + this.group);
        this.group = group;
    }

    /**
     * Функция получения даты рождения студента
     * @return birthDate
     */
    public Calendar getBirthDate() {
        LOGGER.info("Получили дату рождения: " + birthDate);
        return birthDate;
    }

    /**
     * Функция определения даты рождения студента
     * @param birthDate - дата рождения студента
     */
    public void setBirthDate(Calendar birthDate) {
        LOGGER.info("Установили дату рождения: " + this.birthDate);
        this.birthDate = birthDate;
    }
}
