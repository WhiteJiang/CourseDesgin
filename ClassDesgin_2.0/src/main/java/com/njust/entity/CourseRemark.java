package com.njust.entity;

public class CourseRemark {  //用于评价的时候展示课程信息
    private int bool_remark;
    private String teacher;
    private String course_name;
    private String course_introduce;
    private int course_id;
    private int total_evaluate_numb;
    private double grade;
    private double signal_grade;

    public CourseRemark(int bool_remark, String teacher, String course_name, String course_introduce, int course_id, int total_evaluate_numb, double grade, double signal_grade) {
        this.bool_remark = bool_remark;
        this.teacher = teacher;
        this.course_name = course_name;
        this.course_introduce = course_introduce;
        this.course_id = course_id;
        this.total_evaluate_numb = total_evaluate_numb;
        this.grade = grade;
        this.signal_grade = signal_grade;
    }

    public int getBool_remark() {
        return bool_remark;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getCourse_introduce() {
        return course_introduce;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getTotal_evaluate_numb() {
        return total_evaluate_numb;
    }

    public double getGrade() {
        return grade;
    }

    public double getSignal_grade() {
        return signal_grade;
    }

    public void setBool_remark(int bool_remark) {
        this.bool_remark = bool_remark;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setCourse_introduce(String course_introduce) {
        this.course_introduce = course_introduce;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setTotal_evaluate_numb(int total_evaluate_numb) {
        this.total_evaluate_numb = total_evaluate_numb;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setSignal_grade(double signal_grade) {
        this.signal_grade = signal_grade;
    }
}
