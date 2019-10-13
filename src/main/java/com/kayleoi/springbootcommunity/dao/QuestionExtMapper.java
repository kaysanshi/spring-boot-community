package com.kayleoi.springbootcommunity.dao;

import com.kayleoi.springbootcommunity.dto.QuestionQueryDTO;
import com.kayleoi.springbootcommunity.model.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author kay三石
 * @date:2019/10/7
 */
@Repository
public interface QuestionExtMapper {
    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}