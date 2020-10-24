package com.kaysanshi.springbootcommunity.model;

/**
 * @Author kay三石
 * @date:2019/10/7
 */
public class User {
    private Long id;
    private String name;
    private String account_id;
    private String token;
    private Long gmt_create;
    private Long gmt_modify;
    private String bio;
    private String avatarUrl;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public User(Long id, String name, String account_id, String token, Long gmt_create, Long gmt_modify, String bio,String avatarUrl) {
        this.id = id;
        this.name = name;
        this.account_id = account_id;
        this.token = token;
        this.gmt_create = gmt_create;
        this.gmt_modify = gmt_modify;
        this.bio = bio;
        this.avatarUrl =avatarUrl;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Long gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Long getGmt_modify() {
        return gmt_modify;
    }

    public void setGmt_modify(Long gmt_modify) {
        this.gmt_modify = gmt_modify;
    }
}
