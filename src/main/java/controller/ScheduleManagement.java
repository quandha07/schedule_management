package controller;

import data.Schedule;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleManagement {

    //Get All Schedule
    public List<Schedule> getAllSchedules(Connection conn) throws SQLException {
        List<Schedule> schedules = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("select * from schedule");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Schedule schedule = new Schedule(rs.getInt("schedule_id"), rs.getString("time"), rs.getInt("class_id"), rs.getInt("teacher_id"));
            schedules.add(schedule);
        }
        return schedules;
    }
}
