package com.kaysanshi.springbootcommunity.model;

import javax.persistence.*;

public class Notification {
    @Id
    private Long id;

    private Long notifier;

    private Long receiver;

    private Long outerid;

    private Integer type;

    @Column(name = "gmt_create")
    private Long gmtCreate;

    private Integer status;

    @Column(name = "notifier_name")
    private String notifierName;

    @Column(name = "outer_title")
    private String outerTitle;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return notifier
     */
    public Long getNotifier() {
        return notifier;
    }

    /**
     * @param notifier
     */
    public void setNotifier(Long notifier) {
        this.notifier = notifier;
    }

    /**
     * @return receiver
     */
    public Long getReceiver() {
        return receiver;
    }

    /**
     * @param receiver
     */
    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    /**
     * @return outerid
     */
    public Long getOuterid() {
        return outerid;
    }

    /**
     * @param outerid
     */
    public void setOuterid(Long outerid) {
        this.outerid = outerid;
    }

    /**
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
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
     * @return notifier_name
     */
    public String getNotifierName() {
        return notifierName;
    }

    /**
     * @param notifierName
     */
    public void setNotifierName(String notifierName) {
        this.notifierName = notifierName == null ? null : notifierName.trim();
    }

    /**
     * @return outer_title
     */
    public String getOuterTitle() {
        return outerTitle;
    }

    /**
     * @param outerTitle
     */
    public void setOuterTitle(String outerTitle) {
        this.outerTitle = outerTitle == null ? null : outerTitle.trim();
    }
}