package com.jxdedu.entity;
/**
 * 学校评价实体类.
 * @ClassName SchoolEvaluation
 * @author 陈希展 
 * @date 2018年6月14日
 */
/*
 schoolevaluation;
 名称                     类型
 EVALUATEID             NUMBER(7)
 STUID                  NUMBER(7)
 EVALUATEPERSON         VARCHAR2(20)
 EVALUATESCORE          NUMBE(4,2)
 EVALUATECONTENT        VARCHAR2(200)
 */
public class SchoolEvaluation {
   
    private Integer evaluateID; // 评价 ID,对应主键
    private Integer stuID;      // 学生 ID,对应外键
    private Integer evaluateScore;  // 评分
    private String evaluateContent; // 评语
    private String evaluatePerson;  // 评价人
    // 构造器
    public SchoolEvaluation() {}
    public SchoolEvaluation(Integer evaluateID, Integer stuID, Integer evaluateScore, 
            String evaluateContent, String evaluatePerson) {
        this.evaluateID = evaluateID;
        this.stuID = stuID;
        this.evaluateScore = evaluateScore;
        this.evaluateContent = evaluateContent;
        this.evaluatePerson = evaluatePerson;
    }
    // 属性获取/设置器
    public Integer  getEvaluateID()     { return evaluateID;}
    public void     setEvaluateID(int evaluateID) { this.evaluateID = evaluateID;}
    public Integer  getStuID()          { return stuID;}
    public void     setStuID(Integer stuID) { this.stuID = stuID;}
    public Integer  getEvaluateScore()  { return evaluateScore; }
    public void     setEvaluateScore(Integer evaluateScore) { this.evaluateScore = evaluateScore;}
    public String   getEvaluateContent()    {return evaluateContent;}
    public void     setEvaluateContent(String evaluateContent) {this.evaluateContent = evaluateContent;}
    public String   getEvaluatePerson()     {return evaluatePerson;}
    public void     setEvaluatePerson(String evaluatePerson) {this.evaluatePerson = evaluatePerson;}
}
