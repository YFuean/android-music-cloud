package com.example.cloudmusic.entity;

import java.util.List;

public class User {
    private String phone;
    private String password;

    public User() {
    }

    public User(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User[] getUsers(){
        User user = new User();
        User user1 = new User();

        User[] users = {user,user1};

        return users;
    }
}
