package com.kayleoi.springbootcommunity.model;

import javax.persistence.*;

public class Ad {
    @Id
    private Integer id;

    private String title;

    private String url;

    private String image;

    @Column(name = "gmt_start")
    private Long gmtStart;

    @Column(name = "gmt_end")
    private Long gmtEnd;

    @Column(name = "gmt_create")
    private Long gmtCreate;

    @Column(name = "gmt_modified")
    private Long gmtModified;

    private Integer status;

    private String pos;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * @return gmt_start
     */
    public Long getGmtStart() {
        return gmtStart;
    }

    /**
     * @param gmtStart
     */
    public void setGmtStart(Long gmtStart) {
        this.gmtStart = gmtStart;
    }

    /**
     * @return gmt_end
     */
    public Long getGmtEnd() {
        return gmtEnd;
    }

    /**
     * @param gmtEnd
     */
    public void setGmtEnd(Long gmtEnd) {
        this.gmtEnd = gmtEnd;
    }

    /**
     * @return gmt_create
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * @return gmt_modified
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return pos
     */
    public String getPos() {
        return pos;
    }

    /**
     * @param pos
     */
    public void setPos(String pos) {
        this.pos = pos == null ? null : pos.trim();
    }
}