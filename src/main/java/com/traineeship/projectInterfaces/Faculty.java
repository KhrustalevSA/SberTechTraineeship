package com.traineeship.projectInterfaces;

import java.io.Serializable;

public interface Faculty extends Serializable {
    /**
     * Возвращает ID факультета
     * @return ID
     */
    Long getId();

    /**
     * Возвращает Название факультета
     * @return ФИО
     */
    String getName();

    /**
     * Возврщает количество лет учебы
     * @return сколько лет
     */
    Long getYearsQuantity();

    /**
     * Присваивает id факультету
     * @param id
     */
    void setId(Long id);

    /**
     * Присваивает имя факультету
     * @param name
     */
    void setName(String name);

    /**
     * Устанавливает количество лет учебы
     * @param quantity
     */
    void setYearsQuantity(Long quantity);

    boolean equals(Object object);
}
