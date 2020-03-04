package com.endava.internship.s2020.treesetimplementation;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> //TODO consider implementing any interfaces necessary for your collection
{
    private String name;
    private LocalDate dateOfBirth;
    private String details;

    public Student(){}

    public Student(String name, LocalDate dateOfBirth, String details) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.details = details;
    }

    public String getName() { return name; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }

    public String getDetails() { return details; }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", details='" + details + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(dateOfBirth, student.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, details);
    }

    @Override
    public int compareTo(Student o) {
        int comp = this.name.compareTo(o.name);
        if(comp==0) return this.dateOfBirth.compareTo(o.dateOfBirth);
        return comp;
        //return Comparator.comparing(Student::getName).thenComparing(Student::getDetails).compare(this, o);
    }

    /*TODO consider overriding any methods for this object to function properly within a collection:
        1. A student is considered unique by a combination of their name and dateOfBirth
        2. Student names are sorted alphabetically, if two students have the same name, then the older one is
        placed before the younger student in an ordered student list.
    */
}

