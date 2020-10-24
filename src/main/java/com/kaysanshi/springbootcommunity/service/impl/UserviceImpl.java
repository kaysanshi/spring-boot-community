package com.kaysanshi.springbootcommunity.service.impl;

import com.kaysanshi.springbootcommunity.dao.UserMapper;
import com.kaysanshi.springbootcommunity.model.User;
import com.kaysanshi.springbootcommunity.model.UserExample;
import com.kaysanshi.springbootcommunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author kay三石
 * @date:2019/10/6
 */
@Service
public class UserviceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveaOrupdate(User user_model) {
        UserExample userExample =new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user_model.getAccount_id());
        List<User> users=userMapper.selectByExample(userExample);
        if (users.size()==0){
            // 插入
            user_model.setGmt_create(System.currentTimeMillis());
            user_model.setGmt_modify(user_model.getGmt_create());
            user_model.setAvatarUrl(user_model.getAvatarUrl());
            userMapper.insert(user_model);
        } else {
            //更新
            User dbUser = users.get(0);
            User updateUser = new User();
            updateUser.setGmt_modify(System.currentTimeMillis());
            updateUser.setAvatarUrl(user_model.getAvatarUrl());
            updateUser.setName(user_model.getName());
            updateUser.setToken(user_model.getToken());
            updateUser.setId(dbUser.getId());
            UserExample example = new UserExample();
//            example.createCriteria()
//                    .andIdEqualTo(dbUser.getId());
//            userMapper.updateByExampleSelective(updateUser, example);
            userMapper.updateByPrimaryKeySelective(updateUser);
        }
    }
}
