package com.njust.controller;

import com.njust.dao.getCourseIdChapterDao;
import com.njust.dao.uploadCourseDao;
import com.njust.entity.CourseBigChapter;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class uploadCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String  address = null;
        String chapter_name =null;
        int course_id = 0;
        int chapter_id = 0;
        try {
            //第二步、创建FileItem工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //设置临时文件存储目录
            String path = this.getServletContext().getRealPath("/Temp");
            File temp = new File(path);
            factory.setRepository(temp);
            //单位：字节。本例设置边界值为2MB，超过该值会创建临时文件
            factory.setSizeThreshold(1024*1024*2);
            //第三步、创建文件上传核心组件
            ServletFileUpload upload = new ServletFileUpload(factory);
            //设置item的头部字符编码，解决中文乱码问题
            upload.setHeaderEncoding("utf-8");
            //设置单个上传文件的最大值为100MB
            upload.setFileSizeMax(1024*1024*100);
            //设置一次上传所有文件总和的最大值为100MB（上传多个文件时起作用）0.0.0.0.0.0.0.0.0.0.
            upload.setFileSizeMax(1024*1024*100);
            //第四步、解析请求获取所有的item
            List<FileItem> items = upload.parseRequest(req);
            //第五步、遍历item
            String [] t = new String[2];
            for(FileItem item:items) {
                if (item.isFormField()) {
                    t = processFormField(item);
                    if(t[0].equals("chapter_name")){
                        chapter_name = t[1];
                    }else if(t[0].equals("chapter_id")){
                        chapter_id = Integer.parseInt(t[1]);
                    }else if(t[0].equals("course_id")){
                        course_id = Integer.parseInt(t[1]);
                    }
                } else {
                    address = processUploadedFile(item);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        int res = uploadCourseDao.uploadCourse(course_id,chapter_id,address,chapter_name);
        if(res == -1 || res ==0) {
            req.getSession().setAttribute("bool_upload",res); //标识是否更新成功
            resp.sendRedirect("upload_course.jsp");
        }
        List<CourseBigChapter> result = getCourseIdChapterDao.getCourseIDChapter(course_id);
        req.getSession().setAttribute("CourseBigChapter",result);
        resp.sendRedirect("upload_course.jsp");
    }

    private String[] processFormField(FileItem item) {
        String [] temp = new String[2];
        try {
            String name = item.getFieldName();
            //解决中文乱码问题
            String value = item.getString("utf-8");
            temp[0] = name;
            temp[1] =value;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return temp;
    }
    private String processUploadedFile(FileItem item) {
        try {
            InputStream inputStream = item.getInputStream();
            //获取上传文件原始名称
            String fileName = item.getName();
            //解决文件同名问题
            fileName = System.currentTimeMillis()+fileName;
            String path = this.getServletContext().getRealPath("/UploadContent");
            File directory = new File(path);
            if(!directory.exists()) {
                directory.mkdirs();
            }
            String courseAddress = "UploadContent/"+fileName;
            File descFile = new File(path,fileName);
            OutputStream outputStream = new FileOutputStream(descFile);
            int length = -1;
            byte[] buffer = new byte[1024];
            while((length=inputStream.read(buffer))!=-1) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            inputStream.close();
            //删除临时文件
            item.delete();
            return courseAddress;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

