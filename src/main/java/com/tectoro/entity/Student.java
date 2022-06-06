package com.tectoro.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student  {

    @Id
    @Column(name = "student_id")
    private int sId;
    @Column(name = "student_name")
    private String sName;
    @Column(name = "student_age")
    private int sAge;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    List<Book> books;

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> book) {
        this.books = book;
    }

    public Student(int sId, String sName, int sAge, List<Book> book) {
        this.sId = sId;
        this.sName = sName;
        this.sAge = sAge;
        this.books = book;
    }

    public Student(int sId, String sName, int sAge) {

        this.sId = sId;
        this.sName = sName;
        this.sAge = sAge;
    }

    public Student() {
    }
}
