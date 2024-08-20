package controller;

import data.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherManagement {

    //Get All Teachers
    public List<Teacher> getAllTeachers(Connection conn) throws SQLException {
        List<Teacher> teachers = new ArrayList<Teacher>();
        PreparedStatement ps = conn.prepareStatement("select * from teacher");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Teacher teacher = new Teacher(rs.getInt("teacher_id"), rs.getString("teacher_name"), rs.getString("subject"));
            teachers.add(teacher);
        }
        return teachers;
    }
}
