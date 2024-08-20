package data;

public class Student {
    private int student_id;
    private String student_name;
    private String student_date;
    private int class_id;

    public Student(int student_id, String student_name, String student_date, int class_id) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_date = student_date;
        this.class_id = class_id;
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

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_date=" + student_date +
                ", schedule=" + class_id +
                '}';
    }
}
