package com.traineeship.student;

import java.util.Calendar;
import java.util.Scanner;

public class StudentImpl implements Student {

    private String name;
    private Long group;
    private Calendar birthDate;

    public StudentImpl() {
    }

    public StudentImpl(String name, Long group, Calendar birthDate) {
        this.name = name;
        this.group = group;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGroup() {
        return group;
    }

    public void setGroup(Long group) {
        this.group = group;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate){ this.birthDate = birthDate; }
}
