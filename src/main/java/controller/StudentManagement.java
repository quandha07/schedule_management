package controller;

import data.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudentManagement {

    //Get All Students
    public List<Student> getAllStudents(Connection conn) throws SQLException {
        List<Student> students = new ArrayList<Student>();
        PreparedStatement ps = conn.prepareStatement("select * from student");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Student student = new Student(rs.getInt("student_id"), rs.getString("student_name"), rs.getString("student_date"), rs.getInt("schedule_id"));
            students.add(student);
        }
        return students;
    }
}
