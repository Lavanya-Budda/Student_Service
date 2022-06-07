package com.tectoro.daoImpl;

import com.tectoro.dao.StudentDao;
import com.tectoro.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Override
    public String addStudent(Student student) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return "Student details added successfully!!!";
    }

    @Override
    public Student saveStudent(Student student) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            System.out.println("Before save!!");
            session.save(student);
            System.out.println("After save");
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return student;
    }

    @Override
    public List<Student> getAllStudent() {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        List<Student> list = null;
        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("select s.sId,s.sName,s.sAge from Student as s");
            list = (List<Student>) query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public Student getStudentRecord(int sId) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Student student=new Student();
        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("select new Student(s.sId,s.sName,s.sAge) from Student as s where s.sId="+sId);
            List<Student> s=query.list();
            for (Student n:s
            ) {
                student.setsId(n.getsId());
                student.setsName(n.getsName());
                student.setsAge(n.getsAge());
            }
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return student;
    }
}
