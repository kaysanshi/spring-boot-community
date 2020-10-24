package com.kaysanshi.springbootcommunity.enums;

/**
 * @Author kay三石
 * @date:2019/10/16
 */
public enum NotificationStatusEnum {
    UNREAD(0), READ(1);
    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}
