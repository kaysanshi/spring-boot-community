package com.kayleoi.springbootcommunity.dao;

import com.kayleoi.springbootcommunity.model.Comment;
import com.kayleoi.springbootcommunity.model.CommentExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    Comment selectByPrimaryKey(Long parentId);

    void insert(Comment comment);

    List<Comment> selectByExample(CommentExample commentExample);
}