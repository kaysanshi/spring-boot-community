package com.kayleoi.springbootcommunity.dao;

import com.kayleoi.springbootcommunity.dto.UserLogDTO;
import org.springframework.stereotype.Repository;

/**
 * @Author kay三石
 * @date:2019/10/14
 */
@Repository
public interface UserLogMapper {

    void insert(UserLogDTO userLogDTO);

    void updateById(UserLogDTO userLogDTO);
}
