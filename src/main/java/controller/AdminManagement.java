package controller;

import data.Schedule;
import data.Student;
import data.Teacher;
import data.myClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminManagement {

    public AdminManagement() {
    }

//    Create Teacher
    public void addTeacher(Connection conn, Teacher teacher) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO `teacher`  (`teacher_id`, `teacher_name`, `subject`) VALUES (?,?,?)");

        teacher.setTeacher_id(teacher.getTeacher_id());
        statement.setInt(1, teacher.getTeacher_id());

        System.out.println("Teacher name");
        teacher.setTeacher_name(new Scanner(System.in).nextLine());
        statement.setString(2, teacher.getTeacher_name());

        System.out.println("Teacher subject");
        teacher.setSubject(new Scanner(System.in).nextLine());
        statement.setString(3, teacher.getSubject());
        statement.executeUpdate();
    }

    // Update Teacher
    public void updateTeacher(Connection conn, Teacher teacher) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("UPDATE `teacher` SET `subject` = ? WHERE (`teacher_id` = ?)");
        teacher.setSubject(new Scanner(System.in).nextLine());
        statement.setString(1, teacher.getSubject());

        teacher.setTeacher_id(new Scanner(System.in).nextInt());
        statement.setInt(2, teacher.getTeacher_id());
        statement.executeUpdate();
    }

//    Delete Teacher
    public void deleteTeacher(Connection conn, Teacher teacher) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `teacher` WHERE `teacher_id` = ?");

        teacher.setTeacher_id(new Scanner(System.in).nextInt());
        statement.setInt(1, teacher.getTeacher_id());

        statement.executeUpdate();
    }

//    Create Class
    public void addClass(Connection conn, myClass myClass) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO `class` (`class_id`, `class_name`) VALUES (?,?)`)");

        myClass.setClass_id(myClass.getClass_id());
        statement.setInt(1, myClass.getClass_id());

        System.out.println("Class name");
        myClass.setClass_name(new Scanner(System.in).nextLine());
        statement.setString(2, myClass.getClass_name());
        statement.executeUpdate();
    }

//    Update Class
    public void updateClass(Connection conn, myClass myClass) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("UPDATE `class` SET `class_name` = ? WHERE `class_id` = ?");
        myClass.setClass_name(new Scanner(System.in).nextLine());
        statement.setString(1, myClass.getClass_name());

        myClass.setClass_id(new Scanner(System.in).nextInt());
        statement.setInt(2, myClass.getClass_id());
        statement.executeUpdate();
    }

//    Delete Class
    public void deleteClass(Connection conn, myClass myClass) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `class` WHERE `class_name` = ?");
        myClass.setClass_name(new Scanner(System.in).nextLine());
        statement.setString(1, myClass.getClass_name());
        statement.executeUpdate();
    }

    //Create Schedule
    public void addSchedule(Connection conn, Schedule mySchedule) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO `schedule` (`schedule_id`, `time`, `class_id`, `teacher_id`) VALUES (?,?,?,?)");
        System.out.println("CREATE SCHEDULE");
        mySchedule.setSchedule_id(mySchedule.getSchedule_id());
        statement.setInt(1, mySchedule.getSchedule_id());


        System.out.println("Enter the time: ");
        mySchedule.setTime(new Scanner(System.in).nextLine());
        statement.setString(2, mySchedule.getTime());

        System.out.println("Enter the class: ");
        mySchedule.setClass_id(new Scanner(System.in).nextInt());
        statement.setInt(3, mySchedule.getClass_id());

        System.out.println("Enter the teacher: ");
        mySchedule.setTeacher_id(new Scanner(System.in).nextInt());
        statement.setInt(4, mySchedule.getTeacher_id());
        statement.executeUpdate();
    }

    //Update Schedule
    public void updateSchedule(Connection conn, Schedule mySchedule) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("UPDATE `schedule` SET `time` = ?, `class_id` = ?, `teacher_id` = ? WHERE (`schedule_id` = ?)");
        mySchedule.setTime(new Scanner(System.in).nextLine());
        statement.setString(1, mySchedule.getTime());
        mySchedule.setClass_id(new Scanner(System.in).nextInt());
        statement.setInt(2, mySchedule.getClass_id());
        mySchedule.setTeacher_id(new Scanner(System.in).nextInt());
        statement.setInt(3, mySchedule.getTeacher_id());
        mySchedule.setSchedule_id(new Scanner(System.in).nextInt());
        statement.setInt(4, mySchedule.getSchedule_id());
        statement.executeUpdate();
    }

    //Delete Schedule
    public void deleteSchedule(Connection conn, Schedule mySchedule) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `schedule` WHERE `schedule_id` = ?");
        mySchedule.setSchedule_id(new Scanner(System.in).nextInt());
        statement.setInt(1, mySchedule.getSchedule_id());
        statement.executeUpdate();
    }

    //Create Student
    public void addStudent(Connection conn, Student myStudent) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO `student` (`student_id`, `student_name`, `student_date`, `class_id`)");
        myStudent.setStudent_id(myStudent.getStudent_id());
        statement.setInt(1, myStudent.getStudent_id());

        myStudent.setStudent_name(new Scanner(System.in).nextLine());
        statement.setString(2, myStudent.getStudent_name());

        myStudent.setStudent_date(new Scanner(System.in).nextLine());
        statement.setString(3, myStudent.getStudent_date());

        myStudent.setClass_id(new Scanner(System.in).nextInt());
        statement.setInt(4, myStudent.getClass_id());
        statement.executeUpdate();
    }

    //Update Student
    public void updateStudent(Connection conn, Student myStudent) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("UPDATE `student` SET `student_name` = ?, `student_date` = ?, `class_id` = ? WHERE (`student_id` = ?)");
        myStudent.setStudent_name(new Scanner(System.in).nextLine());
        statement.setString(1, myStudent.getStudent_name());
        myStudent.setStudent_date(new Scanner(System.in).nextLine());
        statement.setString(2, myStudent.getStudent_date());
        myStudent.setClass_id(new Scanner(System.in).nextInt());
        statement.setInt(3, myStudent.getClass_id());
        myStudent.setStudent_id(new Scanner(System.in).nextInt());
        statement.setInt(4, myStudent.getStudent_id());
        statement.executeUpdate();
    }

    //Delete Student
    public void deleteStudent(Connection conn, Student myStudent) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `student` WHERE `student_id` = ?");
        myStudent.setStudent_id(new Scanner(System.in).nextInt());
        statement.setInt(1, myStudent.getStudent_id());
        statement.executeUpdate();
    }
}
