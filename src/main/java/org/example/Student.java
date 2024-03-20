package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "Student")
public class Student
{
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name_student")
    private String name_student;

    @Column(name = "surname")
    private String surname;

    @Column(name = "course_name")
    private String course_name;

    public Student(int id, String name_student, String surname, String course_name)
    {
        this.id = id;
        this.name_student = name_student;
        this.surname = surname;
        this.course_name = course_name;
    }

    public Student()
    {

    }

    @Override
    public String toString()
    {
        return "Student" +
                "{" +
                "id = " + id +
                ", name_student = '" + name_student + '\'' +
                ", surname = '" + surname + '\'' +
                ", course_name = '" + course_name + '\'' +
                '}';
    }


    public String getName()
    {
        return name_student;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getCourse_name()
    {
        return course_name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name_student)
    {
        this.name_student = name_student;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public void setCourse_name(String course_name)
    {
        this.course_name = course_name;
    }
}
