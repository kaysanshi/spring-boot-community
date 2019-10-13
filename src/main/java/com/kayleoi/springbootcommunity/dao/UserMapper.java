package com.kayleoi.springbootcommunity.dao;
import com.kayleoi.springbootcommunity.dto.GithubUser;
import com.kayleoi.springbootcommunity.model.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author kay三石
 * @date:2019/10/7
 */
@Repository
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modify,bio,avatar_url) values(#{name},#{account_id},#{token},#{gmt_create},#{gmt_modify}, #{bio},#{avatarUrl})")
    public void insert(User user);
    @Select("select * from user where token=#{token}")
    User findByToken(String token);
    @Select("select * from user where Id=#{creator}")
    User selectByPrimaryKey(Long creator);
}
