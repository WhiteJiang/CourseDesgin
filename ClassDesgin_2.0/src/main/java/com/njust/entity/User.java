package com.njust.entity;

public class User {
    private int id;
    private String account;
    private String pwd;
    private int bool_teacher;
    private String phone;
    private String email;
    private String userName;

    public User(){
    }

    public User( String account, String pwd){
        this.account=account;
        this.pwd =pwd;
    }

    public User(int id, String account, String pwd){
        this.id = id;
        this.account=account;
        this.pwd =pwd;
    }

    public User(int id, String account, String pwd, String phone, String email, String userName) {
        this.id = id;
        this.account = account;
        this.pwd = pwd;
        this.phone = phone;
        this.email = email;
        this.userName = userName;
    }

    public User(String account, String pwd, String phone, String email, String userName) {
        this.account = account;
        this.pwd = pwd;
        this.phone = phone;
        this.email = email;
        this.userName = userName;
    }

    public User(int id, String account, String pwd, int bool_teacher, String phone, String email, String userName) {
        this.id = id;
        this.account = account;
        this.pwd = pwd;
        this.bool_teacher = bool_teacher;
        this.phone = phone;
        this.email = email;
        this.userName = userName;
    }

    public User(String account, String pwd, int bool_teacher, String phone, String email, String userName) {
        this.account = account;
        this.pwd = pwd;
        this.bool_teacher = bool_teacher;
        this.phone = phone;
        this.email = email;
        this.userName = userName;
    }

    public User(int id, int bool_teacher, String userName) {
        this.id = id;
        this.bool_teacher = bool_teacher;
        this.userName = userName;
    }

    public User(String account, String pwd, int bool_teacher, String email) {
        this.account = account;
        this.pwd = pwd;
        this.bool_teacher = bool_teacher;
        this.email = email;
    }


    public void setId(int id) {

        this.id = id;
    }

    public void setAccount(String account) {

        this.account = account;
    }

    public void setPwd(String pwd) {

        this.pwd = pwd;
    }
    public int getId() {

        return id;
    }
    public String getAccount() {

        return account;
    }
    public String getPwd() {
        return pwd;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return userName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String userName) {
        this.userName = userName;
    }

    public void setBool_teacher(int bool_teacher) {
        this.bool_teacher = bool_teacher;
    }

    public int getBool_teacher() {
        return bool_teacher;
    }
}
