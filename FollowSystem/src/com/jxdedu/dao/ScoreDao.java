package com.jxdedu.dao;

import java.util.List;

import com.jxdedu.entity.Score;

/**
 * 实体类Score(学生考核成绩)的数据访问层接口定义;
 * @ClassName ScoreDao
 * @author 陈希展 
 * @date 2018年6月13日
 */
public interface ScoreDao {
    boolean add(Score score);
    boolean update(Score score);

    List<Score> getAll();
    int getTotalCount();
    
}
