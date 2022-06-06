package com.tectoro.service;

import com.tectoro.entity.Student;

import java.util.List;

public interface StudentService {
    String addStudent(Student student);

    Student getStudent(int sId);
    Student saveData(Student  student);


    List<Student> getAllStudent();
    public Student getStd(int sId);
}
