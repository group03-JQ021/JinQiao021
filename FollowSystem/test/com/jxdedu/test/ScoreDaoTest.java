package com.jxdedu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jxdedu.dao.ScoreDao;
import com.jxdedu.entity.Score;
import com.jxdedu.util.MyBatisUtil;

public class ScoreDaoTest {
    SqlSession session = MyBatisUtil.openSession();
    ScoreDao dao = session.getMapper(ScoreDao.class);
    /**
     * 测试 getAll 方法
     */
    public void test01(){
        
        List<Score> list = dao.getAllScore();
        
        // 输出结果
        for (Score s:list){
            System.out.println(s + ",");
        }
        
    }
    /**
     * 测试update
     */
    public void test02(){
        Score score = new Score(1,1,50);
        System.out.println(score);
        System.out.println("update:" + dao.updateScore(score));
        session.commit();
    }
    
    /**
     * 添加分数.
     */
    public void test03(){
        Score score = new Score(1,1,50);
        System.out.println(score);
        System.out.println("update:" + dao.addScore(score));
        session.commit();
    }

    public static void main(String[] args) {
        ScoreDaoTest tester = new ScoreDaoTest();
        // tester.test01();
        tester.test03();
    }

}
