package com.kaysanshi.springbootcommunity.service;

import com.kaysanshi.springbootcommunity.dto.PaginationDTO;
import com.kaysanshi.springbootcommunity.dto.QuestionDTO;
import com.kaysanshi.springbootcommunity.model.Question;

import java.util.List;

/**
 * @Author kay三石
 * @date:2019/10/7
 */
public interface QuestionService {
    QuestionDTO getById(Long id);

    void createOrUpdate(Question question);

    PaginationDTO list(String search, String tag, String sort, Integer page, Integer size);

    List<QuestionDTO> selectRelated(QuestionDTO questionDTO);

    void incView(Long questionId);

    PaginationDTO list(Long id, Integer page, Integer size);
}
