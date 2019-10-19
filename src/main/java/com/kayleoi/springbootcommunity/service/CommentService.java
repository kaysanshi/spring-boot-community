package com.kayleoi.springbootcommunity.service;

import com.kayleoi.springbootcommunity.dto.CommentDTO;
import com.kayleoi.springbootcommunity.enums.CommentTypeEnum;
import com.kayleoi.springbootcommunity.model.Comment;
import com.kayleoi.springbootcommunity.model.User;

import java.util.List;

/**
 * @Author kay三石
 * @date:2019/10/15
 */
public interface CommentService {
    List<CommentDTO> listByTargetId(Long questionId, CommentTypeEnum question);

    void insert(Comment comment, User user);
}
