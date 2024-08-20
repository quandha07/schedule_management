package controller;

import data.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassManagement {
    //Get All Class
    public List<Class> getAllClaas(Connection conn) throws SQLException {
        List<Class> classes = new ArrayList<Class>();
        PreparedStatement ps = conn.prepareStatement("select * from class");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Class myClass = new Class(rs.getInt("class_id"), rs.getString("class_name"));
            classes.add(myClass);
        }
        return classes;
    };
}
