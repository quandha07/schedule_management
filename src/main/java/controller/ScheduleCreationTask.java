package controller;

import data.Schedule;

import java.sql.Connection;
import java.sql.SQLException;

public class ScheduleCreationTask extends Thread{
    private Connection conn;
    private Schedule schedule;
    private AdminManagement adminManagement;

    public ScheduleCreationTask(Connection conn, Schedule schedule, AdminManagement adminManagement) {
        this.conn = conn;
        this.schedule = schedule;
        this.adminManagement = adminManagement;
    }

    @Override
    public void run() {
        try {
            System.out.println("Run Schedule");
            Thread.sleep(2000);
            adminManagement.addSchedule(conn, schedule);
            System.out.println("Successfully added schedule");
        } catch (InterruptedException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
