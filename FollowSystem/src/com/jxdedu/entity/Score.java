package com.jxdedu.entity;

/**
 * 学员成绩表, 每个学员,每门课程只记录最终成绩;
 * 课程成绩位取值范围为 [0, 100]
 * @ClassName Score
 * @author 陈希展 
 * @date 2018年6月13日
 */
public class Score {
    private int stuID;      // 学生id
    private int courseID;   // 课程id
    private int score;      // 学生成绩,
    public Score(int stuID, int courseID, int score) {
        super();
        this.stuID = stuID;
        this.courseID = courseID;
        this.score = score;
    }
    public Score() {
        super();
    }
    /**
     * @return the stuID
     */
    public int getStuID() {
        return stuID;
    }
    /**
     * @param stuID the stuID to set
     */
    public void setStuID(int stuID) {
        this.stuID = stuID;
    }
    /**
     * @return the courseID
     */
    public int getCourseID() {
        return courseID;
    }
    /**
     * @param courseID the courseID to set
     */
    public void setCourseID(int courseID) {
        this.courseID = courseID;
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
        return "成绩 [学号:" + stuID + ", 课程号:" + courseID + ", 成绩:" + score + "]";
    }
    
    /* 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + courseID;
        result = prime * result + score;
        result = prime * result + stuID;
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
        
        return (courseID == other.courseID 
                && score == other.score 
                && stuID == other.stuID);
    }

    
}
