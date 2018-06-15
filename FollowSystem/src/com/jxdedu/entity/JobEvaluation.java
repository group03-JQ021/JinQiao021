

package com.jxdedu.entity;
/**
 * 工作评价实体类.
 * @ClassName JobEvaluation
 * @author 陈希展 
 * @date 2018年6月15日
 */
public class JobEvaluation {

    private Integer dateID;                 // 日期ID
    private Integer stuID;                  // 学生ID
    private Integer optionID;               // 评分项ID
    private String  evaluatePerson;        // 评价人
    private Integer evaluateScore;          // 评分
    private Integer totalScore;             // 总分
    private String  jobEvaluateContent;   // 综合评价
    public JobEvaluation() {}
    public JobEvaluation(Integer dateID, Integer stuID, Integer optionID, String evaluatePerson, 
            Integer evaluateScore, Integer totalScore, String jobEvaluateContent) {
        this.dateID = dateID;
        this.stuID = stuID;
        this.optionID = optionID;
        this.evaluatePerson = evaluatePerson;
        this.evaluateScore = evaluateScore;
        this.totalScore = totalScore;
        this.jobEvaluateContent = jobEvaluateContent;
    }
    public Integer getDateID() {return dateID;}
    public Integer getStuID() {return stuID;}
    public Integer getOptionID() { return optionID;    }
    public String getEvaluatePerson() {return evaluatePerson;}
    public Integer getEvaluateScore() { return evaluateScore;    }
    public Integer getTotalScore() { return totalScore;}
    public String getJobEvaluateContent() {return jobEvaluateContent;}
    
    public void setDateID(Integer dateID) {this.dateID = dateID;    }
    public void setStuID(Integer stuID) {this.stuID = stuID;}
    public void setOptionID(Integer optionID) {this.optionID = optionID;}
    public void setEvaluatePerson(String evaluatePerson) { this.evaluatePerson = evaluatePerson;}
    public void setEvaluateScore(Integer evaluateScore) {this.evaluateScore = evaluateScore;}
    public void setTotalScore(Integer totalScore) {this.totalScore = totalScore;}
    public void setJobEvaluateContent(String jobEvaluateContent) {this.jobEvaluateContent = jobEvaluateContent;}
    @Override
    public String toString() {
        String str = String.format("{日期ID:%s,学生ID:%s,综合评分:%d}",
                dateID, stuID, totalScore);
        return str;
    }
    
}
