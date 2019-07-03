package com.pdffiller.entity;

public class User {
    private String email;
    private String pwd;

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User withPwd(String pwd) {
        this.pwd = pwd;
        return this;

    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }


}
