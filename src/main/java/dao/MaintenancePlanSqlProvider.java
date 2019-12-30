package dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import entity.MaintenancePlan;

public class MaintenancePlanSqlProvider {

    public String insertSelective(MaintenancePlan record) {
        BEGIN();
        INSERT_INTO("maintenance_plan");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
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
        
        if (record.getGroupid() != null) {
            VALUES("groupId", "#{groupid,jdbcType=INTEGER}");
        }
        
        if (record.getPurpose() != null) {
            VALUES("purpose", "#{purpose,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanstate() != null) {
            VALUES("planState", "#{planstate,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(MaintenancePlan record) {
        BEGIN();
        UPDATE("maintenance_plan");
        
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
        
        if (record.getGroupid() != null) {
            SET("groupId = #{groupid,jdbcType=INTEGER}");
        }
        
        if (record.getPurpose() != null) {
            SET("purpose = #{purpose,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanstate() != null) {
            SET("planState = #{planstate,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}