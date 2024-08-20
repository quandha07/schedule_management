package data;

import java.util.List;

public class Admin {
    private final List<Teacher> teacherList;
    private final List<Student> studentList;
    private final List<myClass> classList;
    private final List<Schedule> scheduleList;

    public Admin(List<Teacher> teacherList, List<Student> studentList, List<myClass> classList, List<Schedule> scheduleList) {
        this.teacherList = teacherList;
        this.studentList = studentList;
        this.classList = classList;
        this.scheduleList = scheduleList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<myClass> getClassList() {
        return classList;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }
}
