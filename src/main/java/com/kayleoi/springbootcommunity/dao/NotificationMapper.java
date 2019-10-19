package com.kayleoi.springbootcommunity.dao;

import com.kayleoi.springbootcommunity.model.Notification;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository

public interface NotificationMapper {
    void insert(Notification notification);
}