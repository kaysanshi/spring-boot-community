package com.kayleoi.springbootcommunity.dao;

import com.kayleoi.springbootcommunity.model.Question;
import com.kayleoi.springbootcommunity.model.QuestionExample;
import org.springframework.stereotype.Repository;

/**
 * @Author kay三石
 * @date:2019/10/7
 */
@Repository
public interface QuestionMapper {

    void insert(Question question);

    Question selectByPrimaryKey(Long parentId);

    int updateByExampleSelective(Question updateQuestion, QuestionExample example);

    int updateByPrimaryKeySelective(Question updateQuestion);
}
