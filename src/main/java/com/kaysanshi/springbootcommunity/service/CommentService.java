package com.kaysanshi.springbootcommunity.service;

import com.kaysanshi.springbootcommunity.dto.CommentDTO;
import com.kaysanshi.springbootcommunity.enums.CommentTypeEnum;
import com.kaysanshi.springbootcommunity.model.Comment;
import com.kaysanshi.springbootcommunity.model.User;

import java.util.List;

/**
 * @Author kay三石
 * @date:2019/10/15
 */
public interface CommentService {
    List<CommentDTO> listByTargetId(Long questionId, CommentTypeEnum question);

    void insert(Comment comment, User user);
}
