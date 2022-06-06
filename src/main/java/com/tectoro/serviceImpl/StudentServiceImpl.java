package com.tectoro.serviceImpl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.tectoro.dao.StudentDao;
import com.tectoro.entity.Student;
import com.tectoro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    List<Student> list = List.of(
            new Student(1, "lavanya", 22),
            new Student(2, "sathish", 23),
            new Student(3, "parveen", 22),
            new Student(4, "naveen", 22)
    );

    @Override
    public String addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public Student getStudent(int id) {
        return this.list.stream().filter(Student -> Student.getsId() == id).findAny().orElse(null);
    }

    @Override
    public Student saveData(Student student) {
        System.out.println("Hello Service!!");
        return studentDao.saveStudent(student);
    }

    @Override
    public List<Student> getAllStudent() {
       return studentDao.getAllStudent();
    }

    @Override
    public Student getStd(int sId) {
        return studentDao.getStudentRecord(sId);
    }

}
