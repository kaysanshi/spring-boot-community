package com.kaysanshi.springbootcommunity.dao;

import com.kaysanshi.springbootcommunity.model.User;
import com.kaysanshi.springbootcommunity.model.UserExample;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author kay三石
 * @date:2019/10/7
 */
@Repository
public interface UserMapper {
    //@Insert("insert into user(name,account_id,token,gmt_create,gmt_modify,bio,avatar_url) values(#{name},#{account_id},#{token},#{gmt_create},#{gmt_modify}, #{bio},#{avatarUrl})")
    public void insert(User user);
    @Select("select * from usermata where token=#{token}")
    User findByToken(String token);
   // @Select("select * from user where Id=#{creator}")
    User selectByPrimaryKey(Long creator);

    List<User> selectByExample(UserExample userExample);

    void updateByExampleSelective(User updateUser, UserExample example);

    void updateByPrimaryKeySelective(User updateUser);
}
