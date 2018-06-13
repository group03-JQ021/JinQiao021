package com.jxdedu.entity;

/**
 * 学员成绩表, 每个学员,每门课程只记录最终成绩;
 * 课程成绩位取值范围为 [0, 100]
 * @ClassName Score
 * @author 陈希展 
 * @date 2018年6月13日
 */
public class Score {
    private int stuId;      // 学生id
    private int courseId;   // 课程id
    private int score;      // 学生成绩,
    /**
     * @return the stuId
     */
    public int getStuId() {
        return stuId;
    }
    /**
     * @param stuId the stuId to set
     */
    public void setStuId(int stuId) {
        this.stuId = stuId;
    }
    /**
     * @return the courseId
     */
    public int getCourseId() {
        return courseId;
    }
    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }
    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "成绩 [学号:" + stuId + ", 课程号:" + courseId + ", 成绩:" + score + "]";
    }
    
    /* 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + courseId;
        result = prime * result + score;
        result = prime * result + stuId;
        return result;
    }
    /* 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        // 指向同一个对象,不必再作比较
        if (this == obj) return true;
        // 
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Score other = (Score) obj;
        
        return (courseId == other.courseId 
                && score == other.score 
                && stuId == other.stuId);
    }
    
    
}
