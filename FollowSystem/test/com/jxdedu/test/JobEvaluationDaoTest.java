package com.jxdedu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jxdedu.dao.JobEvaluationDao;
import com.jxdedu.entity.JobEvaluation;
import com.jxdedu.util.MyBatisUtil;

public class JobEvaluationDaoTest {
    SqlSession session = MyBatisUtil.openSession();
    JobEvaluationDao dao = session.getMapper(JobEvaluationDao.class);

    /**
     * 测试 getAll
     */
    public void test01() {

        List<JobEvaluation> list = dao.getAllJobEvaluation();

        // 输出结果
        for (JobEvaluation eval: list) {
            System.out.println(String.format("%s;", eval.toString()));
        }

    }

    /**
     * 测试update
     */
    public void test02(JobEvaluation val) {
        System.out.println(val);
        System.out.println("update:" + dao.updateJobEvaluation(val));
        session.commit();
    }

    /**
     * 测试 add
     */
    public void test03(JobEvaluation val) {
        System.out.println(val);
        System.out.println("update:" + dao.addJobEvaluation(val));
        session.commit();
    }

    /**
     * 测试 getXXXByID
     * 
     * @param val
     */
    public void test04(JobEvaluation val) {
        System.out.println("update:" + dao.getJobEvaluationByID(val));
    }

    /**
     * test for get total count
     */
    public void test05() {
        System.out.println("当前记录总数为:" + dao.getTotalCount());
    }

    public static void main(String[] args) {
        JobEvaluationDaoTest tester = new JobEvaluationDaoTest();
        // tester.test01();

        // update
        /*
         * JobEvaluation val = new JobEvaluation(); val.setEvaluateID(1);
         * val.setStuID(1); val.setEvaluatePerson("猜猜我是谁");
         * val.setEvaluateScore(96);
         * val.setEvaluateContent("此人学习刻苦,基础牢固,学以致用, 评级为优"); tester.test02(val);
         */

        // add
        
         JobEvaluation val = new JobEvaluation(); 
         val.setStuID(1);
         val.setDateID(1);
         val.setOptionID(1);
         val.setEvaluatePerson("猜猜我是谁"); 
         val.setTotalScore(95);
         val.setEvaluateScore(95);
         val.setJobEvaluateContent("工作很努力.");
         tester.test03(val);
         

        // get by ID
        /*
         * JobEvaluation val = new JobEvaluation(); val.setEvaluateID(1);
         * tester.test04(val);
         */

        // get total count
        // tester.test05();

    }

}
