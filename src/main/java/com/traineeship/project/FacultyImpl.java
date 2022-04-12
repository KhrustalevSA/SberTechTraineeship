package com.traineeship.project;

import com.traineeship.logger.LoggerNames;
import com.traineeship.projectInterfaces.Faculty;
import org.apache.log4j.Logger;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "FACULTY")
public class FacultyImpl implements Faculty {
    private static final Logger LOGGER = Logger.getLogger(LoggerNames.CORE.name());

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "faculty_name")
    private String name;

    @Column(name = "years_quantity")
    private Long yearsQuantity;

    @OneToMany
    private List<YearImpl> yearList;

    /**
     * Конструктор - Создание объекта FacultyImpl
     * @see com.traineeship.project.FacultyImpl#FacultyImpl(Long id,String name, Long yearsQuantity)
     */
    public FacultyImpl() {
         LOGGER.info("Создался пустой объект Факультет");
    }

    /**
     * Создание объекта FacultyImpl с заданными значениями полей
     * @param id - идентификационный номер факультета
     * @param name - название факультета
     * @param yearsQuantity - количество лет обучения
     */
    public FacultyImpl(Long id,String name, Long yearsQuantity) {
        this.id = id;
        this.name = name;
        this.yearsQuantity = yearsQuantity;
        LOGGER.info("Создан факультет: " + name + " " + yearsQuantity);
    }


    /**
     * Возвращает ID факультета
     * @return ID
     */
    public Long getId(){
        return  this.id;
    }

    /**
     * Возвращает Название факультета
     * @return ФИО
     */
    public String getName(){
        return this.name;
    }

    /**
     * Возврщает количество лет учебы
     * @return сколько лет
     */
    public Long getYearsQuantity(){
        return this.yearsQuantity;
    }



    /**
     * Присваивает id факультету
     * @param id
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Функция определения названия факультета
     * @param name - название факультета
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Устанавливает количество лет учебы
     * @param quantity
     */
    public void setYearsQuantity(Long quantity){
        this.yearsQuantity = quantity;
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof FacultyImpl ) {
            if (this == object){
                return true;
            } else {
                FacultyImpl val = (FacultyImpl) object;
                return compare(this.getId(),val.getId()) &&
                        compare(this.getName(),val.getName()) &&
                        compare(this.getYearsQuantity(), val.getYearsQuantity());
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
}

