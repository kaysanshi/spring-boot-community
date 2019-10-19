package com.kayleoi.springbootcommunity.enums;

import com.kayleoi.springbootcommunity.model.Notification;

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
