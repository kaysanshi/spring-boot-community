package com.kaysanshi.springbootcommunity.dto;

/**
 * @Author kay三石
 * @date:2019/10/14
 * 登录日志记录
 */
public class UserLogDTO {
    private Integer id;
    private Integer userId;
    private String ip;
    private String questionTitle;
    private String questionContent;
    private String questionTag;
    private Long questionCreateTime;
    private Long loginTime;

    public UserLogDTO() {
    }

    public UserLogDTO(Integer id, Integer userId, String ip, String questionTitle, String questionContent, String questionTag, Long questionCreateTime, Long loginTime) {
        this.id = id;
        this.userId = userId;
        this.ip = ip;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionTag = questionTag;
        this.questionCreateTime = questionCreateTime;
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", userId=" + userId +
                ", ip='" + ip + '\'' +
                ", questionTitle='" + questionTitle + '\'' +
                ", questionContent='" + questionContent + '\'' +
                ", questionTag='" + questionTag + '\'' +
                ", questionCreateTime=" + questionCreateTime +
                ", loginTime=" + loginTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getQuestionTitle() {

        if (questionTitle==null){
            return null;
        }
        return questionTitle;

    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionTag() {
        return questionTag;
    }

    public void setQuestionTag(String questionTag) {
        this.questionTag = questionTag;
    }

    public Long getQuestionCreateTime() {
        return questionCreateTime;
    }

    public void setQuestionCreateTime(Long questionCreateTime) {
        this.questionCreateTime = questionCreateTime;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }
}
