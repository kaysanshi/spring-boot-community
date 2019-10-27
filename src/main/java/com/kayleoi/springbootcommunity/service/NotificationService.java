package com.kayleoi.springbootcommunity.service;

import com.kayleoi.springbootcommunity.dto.NotificationDTO;
import com.kayleoi.springbootcommunity.dto.PaginationDTO;
import com.kayleoi.springbootcommunity.model.User;

/**
 * @Author kay三石
 * @date:2019/10/27
 */
public interface NotificationService {

    PaginationDTO list(Long id, Integer page, Integer size);

    NotificationDTO read(Long id, User user);

    Long unreadCount(Long userId);
}
