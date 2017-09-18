package com.example.demo.entity;

import io.searchbox.annotations.JestId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户")
public class User {
    @ApiModelProperty(required = true, name = "id", value = "用户ID")
    @JestId
    private Integer id;
    @ApiModelProperty(required = true, name = "userName", value = "用户名")
    private String userName;
    @ApiModelProperty(required = true, name = "password", value = "密码")
    private String password;
    @ApiModelProperty(name = "email", value = "邮件地址")
    private String email;
    @ApiModelProperty(name = "nickName", value = "昵称")
    private String nickName;
    @ApiModelProperty(name = "avatar", value = "头像")
    private String avatar;

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
