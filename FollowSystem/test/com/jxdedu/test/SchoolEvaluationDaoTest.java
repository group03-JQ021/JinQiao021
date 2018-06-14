package com.jxdedu.test;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.jxdedu.dao.SchoolEvaluationDao;
import com.jxdedu.entity.SchoolEvaluation;
import com.jxdedu.entity.Score;
import com.jxdedu.util.MyBatisUtil;

public class SchoolEvaluationDaoTest {
    SqlSession session = MyBatisUtil.openSession();
    SchoolEvaluationDao dao = session.getMapper(SchoolEvaluationDao.class);
    /**
     * 测试 getAll 
     */
    public void test01(){
        
        Map<Integer,SchoolEvaluation> map = dao.getAllSchoolEvaluation();
        
        // 输出结果
        for (Integer key:map.keySet()){
            System.out.println(String.format("%s:%s", key, map.get(key)));
        }
        
    }
    /**
     * 测试update
     */
    public void test02(SchoolEvaluation val){
        System.out.println(val);
        System.out.println("update:" + dao.updateSchoolEvaluation(val));
        session.commit();
    }
    
    /**
     * 测试 add
     */
    public void test03(SchoolEvaluation val){
        System.out.println(val);
        System.out.println("update:" + dao.addSchoolEvaluation(val));
        session.commit();
    }
    
    /**
     * 测试 getXXXByID
     * @param val
     */
    public void test04(SchoolEvaluation val){
        System.out.println("update:" + dao.getSchoolEvaluationByID(val));
    }
    /**
     * test for get total count
     */
    public void test05(){
        System.out.println("当前记录总数为:" + dao.getTotalCount());
    }

    public static void main(String[] args) {
        SchoolEvaluationDaoTest tester = new SchoolEvaluationDaoTest();
        // tester.test01();
        
        // update
       /* SchoolEvaluation val = new SchoolEvaluation();
        val.setEvaluateID(1);
        val.setStuID(1);
        val.setEvaluatePerson("猜猜我是谁");
        val.setEvaluateScore(96);
        val.setEvaluateContent("此人学习刻苦,基础牢固,学以致用, 评级为优");
        tester.test02(val);*/
        
        // insert
        /*SchoolEvaluation val = new SchoolEvaluation();
        val.setStuID(1);
        val.setEvaluatePerson("猜猜我是谁");
        val.setEvaluateScore(95);
        val.setEvaluateContent("此人学习刻苦, 评级为良");
        tester.test03(val);*/

        // get by ID
        /*SchoolEvaluation val = new SchoolEvaluation();
        val.setEvaluateID(1);
        tester.test04(val);*/
        
        // get total count
        tester.test05();
        
    }

}
