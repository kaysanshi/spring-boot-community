package com.kaysanshi.springbootcommunity.service;

import com.kaysanshi.springbootcommunity.dto.NotificationDTO;
import com.kaysanshi.springbootcommunity.dto.PaginationDTO;
import com.kaysanshi.springbootcommunity.model.User;

/**
 * @Author kay三石
 * @date:2019/10/27
 */
public interface NotificationService {

    PaginationDTO list(Long id, Integer page, Integer size);

    NotificationDTO read(Long id, User user);

    Long unreadCount(Long userId);
}
