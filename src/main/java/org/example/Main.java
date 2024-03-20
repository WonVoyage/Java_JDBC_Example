package org.example;

import org.hibernate.SessionFactory;

import javax.security.auth.login.Configuration;
import java.util.List;


public class Main
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        System.out.println("Hello world!");
        //List<Student> students = CRUDUtils.getStudentData("Select * from students");
        //System.out.println(students);
//
        //Student student = new Student();
        //student.setName("Ivan");
        //student.setSurname("Ivanov");
        //student.setCourse_name("C++");
//
        //System.out.println(CRUDUtils.saveStudent(student));
    }
}