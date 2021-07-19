package com.njust.entity;

public class StudentCourse {
    private int student_id;
    private int course_id;
    private int bool_remark;

    public StudentCourse(int student_id, int course_id) {
        this.student_id = student_id;
        this.course_id = course_id;
    }

    public StudentCourse(int student_id, int course_id, int bool_remark) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.bool_remark = bool_remark;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getBool_remark() {
        return bool_remark;
    }

    public void setBool_remark(int bool_remark) {
        this.bool_remark = bool_remark;
    }
}
