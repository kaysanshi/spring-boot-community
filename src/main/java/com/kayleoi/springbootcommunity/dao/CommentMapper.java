package com.kayleoi.springbootcommunity.dao;

import com.kayleoi.springbootcommunity.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper {
    Comment selectByPrimaryKey(Long parentId);

    void insert(Comment comment);
}