package com.rongyi.untils;

import java.util.Date;

public class AccToken {
    private Long uid;
    private String username;
    private String avatar;
    private String nickname;
    private Date expireTime;

    public AccToken() {
    }

    public AccToken(Long uid, String username, String avatar, String nickname, Date expireTime) {
        this.uid = uid;
        this.username = username;
        this.avatar = avatar;
        this.nickname = nickname;
        this.expireTime = expireTime;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "AccToken{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", nickname='" + nickname + '\'' +
                ", expireTime=" + expireTime +
                '}';
    }
}
