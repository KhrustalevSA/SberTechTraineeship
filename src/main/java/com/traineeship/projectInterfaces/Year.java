package com.traineeship.projectInterfaces;

import java.io.Serializable;

public interface Year extends Serializable {
    /**
     * Возвращает ID курса
     * @return ID
     */
    Long getId();

    /**
     * Возвращает год начала обучения
     * @return год
     */
    Long getStartYear();

    /**
     * Возврщает год обучения
     * @return год
     */
    Long getYear();

    /**
     * Возврщает количество студентов на курсе
     * @return количество студентов
     */
    Long getStudentsQuantity();

    /**
     * Присваивает id курсу
     * @param id
     */
    void setId(Long id);

    /**
     * Присваивает год начала обучения курсу
     * @param start_year
     */
    void setName(Long start_year);

    /**
     * Устанавливает год обучения
     * @param year
     */
    void setYear(Long year);

    /**
     * Устанавливает количество студентов на курсе
     * @param studentsQuantity
     */
    void getStudentsQuantity(Long studentsQuantity);

    boolean equals(Object object);
}
