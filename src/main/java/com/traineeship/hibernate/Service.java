package com.traineeship.hibernate;

import com.traineeship.projectInterfaces.Student;

public interface Service<T> {
    void add(T value);
    boolean equalsStudents(Student student, Long id);
    T find(long id);
    void addOrUpdate(T value);
}
