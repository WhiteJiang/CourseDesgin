package com.njust.entity;

public class CourseBigChapter {
    private int course_id;
    private int course_chapter_id;
    private String course_address;
    private String chapter_name;

    public CourseBigChapter(int course_id, int course_chapter_id,String course_address, String chapter_name) {
        this.course_id = course_id;
        this.course_address = course_address;
        this.chapter_name = chapter_name;
        this.course_chapter_id = course_chapter_id;
    }

    public CourseBigChapter(int course_chapter_id, String course_address, String chapter_name) {
        this.course_chapter_id = course_chapter_id;
        this.course_address = course_address;
        this.chapter_name = chapter_name;
    }

    public CourseBigChapter() {
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setCourse_address(String course_address) {
        this.course_address = course_address;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public void setCourse_chapter_id(int course_chapter_id) {
        this.course_chapter_id = course_chapter_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public String getCourse_address() {
        return course_address;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public int getCourse_chapter_id() {
        return course_chapter_id;
    }
}
