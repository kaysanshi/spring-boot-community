package com.kayleoi.springbootcommunity.dao;

import com.kayleoi.springbootcommunity.model.Question;
import com.kayleoi.springbootcommunity.model.QuestionExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    Object countByExample(QuestionExample questionExample);

    List<Question> selectByExampleWithRowbounds(QuestionExample example, RowBounds rowBounds);
}
