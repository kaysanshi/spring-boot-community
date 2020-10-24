package com.kaysanshi.springbootcommunity.dao;

import com.kaysanshi.springbootcommunity.model.Comment;
import com.kaysanshi.springbootcommunity.model.CommentExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    Comment selectByPrimaryKey(Long parentId);

    void insert(Comment comment);

    List<Comment> selectByExample(CommentExample commentExample);
}