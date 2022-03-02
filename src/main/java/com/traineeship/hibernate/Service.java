package com.traineeship.hibernate;

import com.traineeship.projectInterfaces.Student;

public interface Service<T> {
    void add(T value);
    T find(long id);
}
