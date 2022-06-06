package com.tectoro.dao;

import com.tectoro.entity.Student;

import java.util.List;

public interface StudentDao {
    String addStudent(Student student);
    public Student saveStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentRecord(int sId);
}
