import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.*;
import data.*;
import mysqldatabase.DatabaseConnection;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = new DatabaseConnection().getConnection();
        Schedule schedule = new Schedule();
        TeacherManagement teacherManagement = new TeacherManagement();
        StudentManagement studentManagement = new StudentManagement();
        ClassManagement classManagement = new ClassManagement();
        ScheduleManagement scheduleManagement = new ScheduleManagement();
        Admin admin = new Admin(teacherManagement.getAllTeachers(connection), studentManagement.getAllStudents(connection), classManagement.getAllClaas(connection), scheduleManagement.getAllSchedules(connection));
        Teacher teacher = new Teacher();
        AdminManagement adminManagement = new AdminManagement();

        //Add
//        adminManagement.addTeacher(connection, new Teacher());
//        adminManagement.addSchedule(connection, new Schedule());
//        adminManagement.addClass(connection, new myClass());
//        adminManagement.addStudent(connection, new Student());

        //Call
//        callingAPI();

        //Asynchronous programming
//        asynchronous(admin,connection,schedule,adminManagement);

    }

    public static void callingAPI() throws IOException {
        URL url = new URL("https://run.mocky.io/v3/06bb687b-082b-4e78-a326-223190b2afab");

        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();

        BufferedReader inputStream  = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = inputStream.readLine()) != null) {
            response.append(inputLine);
        }

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Student[] person = gson.fromJson(String.valueOf(response), Student[].class);
        System.out.println(Arrays.toString(person));
    }
    public static void getAll(Admin admin) {
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

    }
    public static void asynchronous(Admin admin, Connection connection, Schedule schedule, AdminManagement adminManagement) throws SQLException {
        try {
            Thread dataExportTask = new Thread(new DataExportTask(admin, "output.txt"));
            dataExportTask.start();

            ScheduleCreationTask scheduleCreationTask = new ScheduleCreationTask(connection, schedule, adminManagement);
            scheduleCreationTask.start();

            System.out.println("All tasks started");
        } catch (Exception e) {
            System.out.println("Failed to complete task: " + e.getMessage());
        }
    }
}


