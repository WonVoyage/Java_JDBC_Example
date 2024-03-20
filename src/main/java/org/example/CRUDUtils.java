package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils
{
    public static String INSERT_STUDENT = "Insert Into students(name_student, surname, course_name) VALUES(?, ?, ?)";
    public static String UPDATE_STUDENT = "Update students SET course_name = ? Where id = ?";

    public static List<Student> getStudentData(String query)
    {
        List<Student> students = new ArrayList<Student>();

        try(Connection connection = DBUtils.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String name_student = resultSet.getString("name_student");
                String surname = resultSet.getString("surname");
                String course_name = resultSet.getString("course_name");

                students.add(new Student(id, name_student, surname, course_name));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return students;
    }

    public static List<Student> saveStudent(Student student)
    {
        List<Student> students = new ArrayList<>();

        try(Connection connection = DBUtils.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getCourse_name());
            preparedStatement.executeUpdate();

            PreparedStatement allStudents = connection.prepareStatement("Select * From students");
            ResultSet rs = allStudents.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt("id");
                String name_student = rs.getString("name_student");
                String surname = rs.getString("surname");
                String course_name = rs.getString("course_name");

                students.add(new Student(id, name_student, surname, course_name));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return students;
    }

    public static List<Student> updateStudent(int studentID, String course_name)
    {
        List<Student> updateStudents = new ArrayList<>();

        try(Connection connection = DBUtils.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
            preparedStatement.setString(1, course_name);
            preparedStatement.setInt(2, studentID);
            preparedStatement.executeUpdate();

            PreparedStatement allStudents = connection.prepareStatement("Select * From students");
            ResultSet rs = allStudents.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt("id");
                String name_student = rs.getString("name_student");
                String surname = rs.getString("surname");
                String course_name1 = rs.getString("course_name");

                updateStudents.add(new Student(id, name_student, surname, course_name1));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return updateStudents;
    }
}
