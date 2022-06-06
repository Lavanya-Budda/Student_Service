package com.tectoro.entity;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "author_id")
    private int aId;
    @Column(name = "author_name")
    private String aName;
    @Column(name = "author_age")
    private int aAge;
    @Column(name = "author_books")
    private int no_of_books_written;
    @Transient
    @Column(name = "book_id")
    private int bId;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public int getaAge() {
        return aAge;
    }

    public void setaAge(int aAge) {
        this.aAge = aAge;
    }

    public int getNo_of_books_written() {
        return no_of_books_written;
    }

    public void setNo_of_books_written(int no_of_books_written) {
        this.no_of_books_written = no_of_books_written;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }
}
