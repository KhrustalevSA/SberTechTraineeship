package com.traineeship.hibernate;

import com.traineeship.projectInterfaces.Student;

public interface Service<T> {
    void add(T value);
    T get(T value, Long id);
    boolean equalsObjects(T value, Long id);
    boolean equalsObjectsFunc(T value1, T value2);
    boolean equalsStudents(Student student1, Student student2);
    void addOrUpdate(T value);
    void Update(T value, Long id);
    void UpdateStudent(Student student);
    T find(long id);
}
