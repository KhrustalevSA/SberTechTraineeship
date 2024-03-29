package com.traineeship.student;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Интерфес, описывающий состояние студента
 * @author popovtsev-pv
 * @since 06.10.2021
 */
public interface Student extends Serializable {
    /**
     * Возвращает ФИО студента
     * @return ФИО
     */
    String getName();

    /**
     * Возврщает номер группы студента
     * @return номер группы
     */
    Long getGroup();

    /**
     * Возвращает дату рождения
     * @return дата рождения
     */
    Calendar getBirthDate();

    /**
     * Присваивает имя студенту
     * @param name
     */
    void setName(String name);

    /**
     * Устанавливает номер группы студента
     * @param group
     */
    void setGroup(Long group);

    /**
     * Устанавливает дату рождения студента
     * @param birthDate
     */

    void setBirthDate(Calendar birthDate);
}