package com.traineeship.projectInterfaces;

/**
 * Интерфес, описывающий сервис для работы со студентами
 * @author popovtsev-pv
 * @since 06.10.2021
 */
public interface StudentService {
    /**
     * Добавляет информацию о новом студенте
     * @param student информация о студенте
     */
    void add(Student student);

    /**
     * Получение инормации о студенте по ФИО
     * @param name ФИО студента
     * @return информация о студенте
     */
    Student get(String name);
}
