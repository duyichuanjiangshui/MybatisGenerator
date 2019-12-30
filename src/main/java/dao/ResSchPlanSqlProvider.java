package dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import entity.ResSchPlan;

public class ResSchPlanSqlProvider {

    public String insertSelective(ResSchPlan record) {
        BEGIN();
        INSERT_INTO("res_sch_plan");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getImplplanid() != null) {
            VALUES("implPlanId", "#{implplanid,jdbcType=INTEGER}");
        }
        
        if (record.getResid() != null) {
            VALUES("resId", "#{resid,jdbcType=INTEGER}");
        }
        
        if (record.getResnum() != null) {
            VALUES("resNum", "#{resnum,jdbcType=INTEGER}");
        }
        
        if (record.getPlanstate() != null) {
            VALUES("planState", "#{planstate,jdbcType=INTEGER}");
        }
        
        if (record.getAllocatedtime() != null) {
            VALUES("allocatedTime", "#{allocatedtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ResSchPlan record) {
        BEGIN();
        UPDATE("res_sch_plan");
        
        if (record.getImplplanid() != null) {
            SET("implPlanId = #{implplanid,jdbcType=INTEGER}");
        }
        
        if (record.getResid() != null) {
            SET("resId = #{resid,jdbcType=INTEGER}");
        }
        
        if (record.getResnum() != null) {
            SET("resNum = #{resnum,jdbcType=INTEGER}");
        }
        
        if (record.getPlanstate() != null) {
            SET("planState = #{planstate,jdbcType=INTEGER}");
        }
        
        if (record.getAllocatedtime() != null) {
            SET("allocatedTime = #{allocatedtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}