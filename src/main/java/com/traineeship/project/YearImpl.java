package com.traineeship.project;

import com.traineeship.logger.LoggerNames;
import com.traineeship.projectInterfaces.Faculty;
import com.traineeship.projectInterfaces.Year;
import org.apache.log4j.Logger;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Year")
public class YearImpl implements Year {

    private static final Logger LOGGER = Logger.getLogger(LoggerNames.CORE.name());
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "start_year")
    private long startYear;

    @Column(name = "year")
    private Long year;

    @Column(name = "students_quantity")
    private Long studentsQuantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_id")
    private FacultyImpl faculty;

    /**
     * Конструктор - Создание объекта YearImpl
     * @see YearImpl#YearImpl(Long id,Long start_year, Long year, Long studentsQuantity)
     */
    public YearImpl() {
        LOGGER.info("Создался пустой объект курс");
    }

    /**
     * Создание объекта YearImpl с заданными значениями полей
     * @param id - идентификационный номер курса
     * @param startYear - год начала обучения
     * @param year - текущий год обучения
     * @param studentsQuantity - количество студентов на курсе
     * @see YearImpl#YearImpl()
     */
    public YearImpl(Long id,Long startYear, Long year, Long studentsQuantity) {
        this.id = id;
        this.startYear = startYear;
        this.year = year;
        this.studentsQuantity = studentsQuantity;
        LOGGER.info("Создан курс: " + startYear + " " + year + " " + studentsQuantity);
    }



    /**
     * Возвращает ID курса
     * @return ID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Возвращает год начала обучения
     * @return год
     */
    public Long getStartYear() {
        return  this.startYear;
    }

    /**
     * Возврщает год обучения
     * @return год
     */
    public Long getYear() {
        return this.year;
    }

    /**
     * Возврщает количество студентов на курсе
     * @return количество студентов
     */
    public Long getStudentsQuantity(){
        return this.studentsQuantity;
    }

    /**
     * Присваивает id курсу
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Присваивает го начала обучения
     * @param start_year
     */
    public void setName(Long start_year) {
        this.startYear = start_year;
    }

    /**
     * Устанавливает год обучения
     * @param year
     */
    public void setYear(Long year) {
        this.year = year;
    }

    /**
     * Устанавливает количество студентов на курсе
     * @param studentsQuantity
     */
    public void getStudentsQuantity(Long studentsQuantity) {
        this.studentsQuantity = studentsQuantity;
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof YearImpl ) {
            if (this == object){
                return true;
            } else {
                YearImpl val = (YearImpl) object;
                return compare(this.getId(),val.getId()) &&
                        compare(this.getYear(),val.getYear()) &&
                        compare(this.getStartYear(), val.getStartYear()) &&
                        compare(this.getStudentsQuantity(), val.getStudentsQuantity());
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
