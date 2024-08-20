package data;

public class Student {
    private int student_id;
    private String student_name;
    private String student_date;
    private int schedule_id;

    public Student(int student_id, String student_name, String student_date, int schedule_id) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_date = student_date;
        this.schedule_id = schedule_id;
    }

    public Student() {

    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_date() {
        return student_date;
    }

    public void setStudent_date(String student_date) {
        this.student_date = student_date;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule) {
        this.schedule_id = schedule;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_date=" + student_date +
                ", schedule=" + schedule_id +
                '}';
    }
}
