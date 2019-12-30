package dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import entity.StaffSchPlan;

public class StaffSchPlanSqlProvider {

    public String insertSelective(StaffSchPlan record) {
        BEGIN();
        INSERT_INTO("staff_sch_plan");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getImplplanid() != null) {
            VALUES("implPlanId", "#{implplanid,jdbcType=INTEGER}");
        }
        
        if (record.getProjectid() != null) {
            VALUES("projectId", "#{projectid,jdbcType=INTEGER}");
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
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(StaffSchPlan record) {
        BEGIN();
        UPDATE("staff_sch_plan");
        
        if (record.getImplplanid() != null) {
            SET("implPlanId = #{implplanid,jdbcType=INTEGER}");
        }
        
        if (record.getProjectid() != null) {
            SET("projectId = #{projectid,jdbcType=INTEGER}");
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
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}