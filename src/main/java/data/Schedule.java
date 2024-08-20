package data;

public class Schedule {
    private int schedule_id;
    private String time;
    private int class_id;
    private int teacher_id;

    public Schedule(int schedule_id, String time, int class_id, int teacher_id) {
        this.schedule_id = schedule_id;
        this.time = time;
        this.class_id = class_id;
        this.teacher_id = teacher_id;
    }

    public Schedule() {
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "schedule_id=" + schedule_id +
                ", time='" + time + '\'' +
                ", class_id=" + class_id +
                ", teacher_id=" + teacher_id +
                '}';
    }
}
