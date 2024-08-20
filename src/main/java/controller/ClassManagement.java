package controller;

import data.myClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassManagement {
    //Get All Class
    public List<myClass> getAllClaas(Connection conn) throws SQLException {
        List<myClass> classes = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("select * from class");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            myClass myClass = new myClass(rs.getInt("class_id"), rs.getString("class_name"));
            classes.add(myClass);
        }
        return classes;
    };
}
