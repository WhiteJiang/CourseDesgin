package com.njust.service;

import com.njust.entity.Course;
import com.njust.dao.myCourseDao;

import java.sql.SQLException;
import java.util.List;

public class courseService {
    public static List<Course> ShowAllCourse(int id, int current_page ) throws SQLException, ClassNotFoundException {
       List<Course> courses = myCourseDao.myCourse(id, current_page);
        return courses;
    }
    public static int countCourse(int id){
        int num = myCourseDao.countNum(id);
        return num;
    }
}
