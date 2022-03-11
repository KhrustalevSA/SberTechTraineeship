package com.traineeship.hibernate;

public interface Service<T> {
    void add(T value);
    T get(T value, Long id);
    boolean equals(Object value);
    boolean equals(T value, Long id);
    void addOrUpdate(T value);
    void Update(T value, Long id);
    T find(long id);
}
