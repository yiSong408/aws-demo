package com.rongyi.dto;

public class RegisterDto {
    private String username;
    private String password;
    private String Email;
    private String uid;

    public RegisterDto() {
    }

    public RegisterDto(String username, String password, String email, String uid) {
        this.username = username;
        this.password = password;
        Email = email;
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "RegisterDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", Email='" + Email + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
