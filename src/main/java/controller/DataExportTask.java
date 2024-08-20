package controller;

import data.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataExportTask implements Runnable {
    private Admin admin;
    private String fileName;

    public DataExportTask(Admin admin, String fileName) {
        this.admin = admin;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Teachers:");
            writer.newLine();
            for (Teacher teacher : admin.getTeacherList()) {
                writer.write(teacher.toString());
                writer.newLine();
            }

            writer.write("Students:");
            writer.newLine();
            for (Student student : admin.getStudentList()) {
                writer.write(student.toString());
                writer.newLine();
            }

            writer.write("Classes:");
            writer.newLine();
            for (myClass clazz : admin.getClassList()) {
                writer.write(clazz.toString());
                writer.newLine();
            }

            writer.write("Schedules:");
            writer.newLine();
            for (Schedule schedule : admin.getScheduleList()) {
                writer.write(schedule.toString());
                writer.newLine();
            }

            System.out.println("Data export completed.");
        } catch (IOException e) {
            System.err.println("Failed to write data to file: " + e.getMessage());
        }
    }
}
