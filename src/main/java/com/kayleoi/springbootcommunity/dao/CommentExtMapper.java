package com.kayleoi.springbootcommunity.dao;

import com.kayleoi.springbootcommunity.model.Comment;
import org.springframework.stereotype.Repository;

/**
 * @Author kay三石
 * @date:2019/10/16
 */
@Repository
public interface CommentExtMapper {
    void incCommentCount(Comment parentComment);
}
