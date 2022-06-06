package com.tectoro.controller;

import com.tectoro.entity.Student;
import com.tectoro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/student/{sId}")
    public Student getStudent(@PathVariable("sId") int sId) {
        System.out.println("Hellohgdhvd");
        Student student = this.studentService.getStd(sId);
        System.out.println("Hello");
        List books = this.restTemplate.getForObject("http://book-service/book/get/"+sId, List.class, sId);
        student.setBooks(books);
        return student;
    }

    @PostMapping("/addstudent")
    public String addStudent(@RequestBody Student student) {
        String s = null;
        try {
            s = studentService.addStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    @GetMapping("/{id}")
    public Student gettStudent(@PathVariable("id") int id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
        try {
            if (student != null) {
                return studentService.saveData(student);
            } else {
                System.out.println("No data!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @GetMapping("/getallstd")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }
}
