package com.njust.entity;

import java.sql.Timestamp;

public class Course {
    private String category;
    private Timestamp creatTime;
    private String teacher;
    private String course_name;
    private String course_introduce;
    private int id; //老师ID
    private int course_id;
    private int total_evaluate_numb;
    private double grade;

    public Course(String category, Timestamp creatTime, String teacher, String course_name, int id, int course_id, int total_evaluate_numb, double grade) {
        this.category = category;
        this.creatTime = creatTime;
        this.teacher = teacher;
        this.course_name = course_name;
        this.id = id;
        this.course_id = course_id;
        this.total_evaluate_numb = total_evaluate_numb;
        this.grade = grade;
    }

    public Course(String category, Timestamp creatTime, String teacher, String course_name, String course_introduce, int id,  int total_evaluate_numb, double grade) {
        this.category = category;
        this.creatTime = creatTime;
        this.teacher = teacher;
        this.course_name = course_name;
        this.course_introduce = course_introduce;
        this.id = id;
        this.total_evaluate_numb = total_evaluate_numb;
        this.grade = grade;
    }

    public Course(String category, String teacher, String course_name, String course_introduce,double grade ,int course_id) {
        this.category = category;
        this.teacher = teacher;
        this.course_name = course_name;
        this.course_introduce = course_introduce;
        this.course_id = course_id;
        this.grade = grade;
    }

    public Course(String category, Timestamp creatTime, String teacher, String course_name, String course_introduce, int total_evaluate_numb, double grade) {
        this.category = category;
        this.creatTime = creatTime;
        this.teacher = teacher;
        this.course_name = course_name;
        this.course_introduce = course_introduce;
        this.total_evaluate_numb = total_evaluate_numb;
        this.grade = grade;
    }

    public Course(String category, Timestamp creatTime, String teacher, String course_name, String course_introduce, int id, int course_id, int total_evaluate_numb, double grade) {
        this.category = category;
        this.creatTime = creatTime;
        this.teacher = teacher;
        this.course_name = course_name;
        this.course_introduce = course_introduce;
        this.id = id;
        this.course_id = course_id;
        this.total_evaluate_numb = total_evaluate_numb;
        this.grade = grade;
    }

    public Course(String teacher, String course_name, String course_introduce, int total_evaluate_numb, double grade) {
        this.teacher = teacher;
        this.course_name = course_name;
        this.course_introduce = course_introduce;
        this.total_evaluate_numb = total_evaluate_numb;
        this.grade = grade;
    }

    public Course(String category, String teacher, String course_name, String course_introduce, int total_evaluate_numb, double grade) {
        this.category = category;
        this.teacher = teacher;
        this.course_name = course_name;
        this.course_introduce = course_introduce;
        this.total_evaluate_numb = total_evaluate_numb;
        this.grade = grade;
    }


    @Override
    public String toString() {
        return "Course{" +
                "category='" + category + '\'' +
                ", creatTime=" + creatTime +
                ", teacher='" + teacher + '\'' +
                ", course_name='" + course_name + '\'' +
                ", id=" + id +
                ", total_evaluate_numb=" + total_evaluate_numb +
                ", grade=" + grade +
                '}';
    }

    public Course(String category, Timestamp creatTime, String teacher, String course_name, int id) {
        this.category = category;
        this.creatTime = creatTime;
        this.teacher = teacher;
        this.course_name = course_name;
        this.id = id;
    }

    public Course(String category, Timestamp creatTime, String teacher, String course_name, int id, int total_evaluate_numb, double grade) {
        this.category = category;
        this.creatTime = creatTime;
        this.teacher = teacher;
        this.course_name = course_name;
        this.id = id;
        this.total_evaluate_numb = total_evaluate_numb;
        this.grade = grade;
    }

    public Course() {
    }


    public String getCategory() {
        return category;
    }

    public String getTeacher() {
        return teacher;
    }

    public double getGrade() {
        return grade;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }


    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getTotal_evaluate_numb() {
        return total_evaluate_numb;
    }

    public void setTotal_evaluate_numb(int total_evaluate_numb) {
        this.total_evaluate_numb = total_evaluate_numb;
    }

    public Timestamp getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Timestamp creatTime) {
        this.creatTime = creatTime;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_introduce() {
        return course_introduce;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_introduce(String course_introduce) {
        this.course_introduce = course_introduce;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
}

