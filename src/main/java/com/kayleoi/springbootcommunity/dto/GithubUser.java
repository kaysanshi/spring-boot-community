package com.kayleoi.springbootcommunity.dto;

/**
 * @Author kay三石
 * @date:2019/10/7
 * github中返回user信息的封装
 */
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public GithubUser(String name, Long id, String bio, String avatar_url) {
        this.name = name;
        this.id = id;
        this.bio = bio;
        this.avatar_url = avatar_url;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", bio='" + bio + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
