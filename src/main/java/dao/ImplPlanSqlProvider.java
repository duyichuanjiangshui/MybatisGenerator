package dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import entity.ImplPlan;

public class ImplPlanSqlProvider {

    public String insertSelective(ImplPlan record) {
        BEGIN();
        INSERT_INTO("impl_plan");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getProjectid() != null) {
            VALUES("projectId", "#{projectid,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getStepname() != null) {
            VALUES("stepName", "#{stepname,jdbcType=VARCHAR}");
        }
        
        if (record.getDifficultylevel() != null) {
            VALUES("difficultyLevel", "#{difficultylevel,jdbcType=INTEGER}");
        }
        
        if (record.getStarttime() != null) {
            VALUES("startTime", "#{starttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpectedendtime() != null) {
            VALUES("expectedEndTime", "#{expectedendtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getActualendtime() != null) {
            VALUES("actualEndTime", "#{actualendtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getState() != null) {
            VALUES("state", "#{state,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ImplPlan record) {
        BEGIN();
        UPDATE("impl_plan");
        
        if (record.getProjectid() != null) {
            SET("projectId = #{projectid,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getStepname() != null) {
            SET("stepName = #{stepname,jdbcType=VARCHAR}");
        }
        
        if (record.getDifficultylevel() != null) {
            SET("difficultyLevel = #{difficultylevel,jdbcType=INTEGER}");
        }
        
        if (record.getStarttime() != null) {
            SET("startTime = #{starttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpectedendtime() != null) {
            SET("expectedEndTime = #{expectedendtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getActualendtime() != null) {
            SET("actualEndTime = #{actualendtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getState() != null) {
            SET("state = #{state,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}