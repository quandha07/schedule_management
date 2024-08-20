import controller.*;
import data.*;
import data.Class;
import mysqldatabase.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = new DatabaseConnection().getConnection();
        Schedule schedule = new Schedule();
        TeacherManagement teacherManagement = new TeacherManagement();
        StudentManagement studentManagement = new StudentManagement();
        ClassManagement classManagement = new ClassManagement();
        ScheduleManagement scheduleManagement = new ScheduleManagement();

        //Get All
        Admin admin = new Admin(teacherManagement.getAllTeachers(connection), studentManagement.getAllStudents(connection), classManagement.getAllClaas(connection), scheduleManagement.getAllSchedules(connection));
        for(int i = 0; i < admin.getTeacherList().size(); i++){
            System.out.println(admin.getTeacherList().get(i).toString());
        }

        for(int i = 0; i < admin.getStudentList().size(); i++){
            System.out.println(admin.getStudentList().get(i).toString());
        }

        for(int i = 0; i < admin.getClassList().size(); i++){
            System.out.println(admin.getClassList().get(i).toString());
        }

        for(int i = 0; i < admin.getScheduleList().size(); i++){
            System.out.println(admin.getScheduleList().get(i).toString());
        }

        //CRUD
        AdminManagement adminManagement = new AdminManagement();

        adminManagement.addTeacher(connection, new Teacher());
        adminManagement.addSchedule(connection, new Schedule());
        adminManagement.addClass(connection, new Class());
        adminManagement.addStudent(connection, new Student());
        Teacher teacher = new Teacher();
//        adminManagement.addTeacher(connection, teacher);
//        adminManagement.deleteTeacher(connection, teacher);


        try {
            ScheduleCreationTask scheduleCreationTask = new ScheduleCreationTask(connection, schedule, adminManagement);
            scheduleCreationTask.start();

            GradeReportCreationTask gradeReportCreationTask = new GradeReportCreationTask();
            gradeReportCreationTask.start();

            scheduleCreationTask.join();
            gradeReportCreationTask.join();
            System.out.println("All Task completed");
        } catch (Exception e) {
            System.out.println("Failed to complete task");
        }

    }
}