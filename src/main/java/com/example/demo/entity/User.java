package com.example.demo.entity;

public class User {
    private Integer id;         //id
    private String userName;    //用户名
    private String password;    //密码
    private String email;       //邮件地址
    private String nickName;    //昵称
    private String avatar;      //头像

    public User() {

    }

    public User(Integer id, String userName, String password, String email, String nickName, String avatar) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        this.avatar = avatar;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
