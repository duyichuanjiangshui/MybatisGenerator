package dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import entity.ImplCost;

public class ImplCostSqlProvider {

    public String insertSelective(ImplCost record) {
        BEGIN();
        INSERT_INTO("impl_cost");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getStaffid() != null) {
            VALUES("staffId", "#{staffid,jdbcType=INTEGER}");
        }
        
        if (record.getImplplanid() != null) {
            VALUES("implPlanId", "#{implplanid,jdbcType=INTEGER}");
        }
        
        if (record.getProjectid() != null) {
            VALUES("projectId", "#{projectid,jdbcType=INTEGER}");
        }
        
        if (record.getImplday() != null) {
            VALUES("implDay", "#{implday,jdbcType=INTEGER}");
        }
        
        if (record.getStafftype() != null) {
            VALUES("staffType", "#{stafftype,jdbcType=INTEGER}");
        }
        
        if (record.getImplstafftotal() != null) {
            VALUES("implStaffTotal", "#{implstafftotal,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ImplCost record) {
        BEGIN();
        UPDATE("impl_cost");
        
        if (record.getStaffid() != null) {
            SET("staffId = #{staffid,jdbcType=INTEGER}");
        }
        
        if (record.getImplplanid() != null) {
            SET("implPlanId = #{implplanid,jdbcType=INTEGER}");
        }
        
        if (record.getProjectid() != null) {
            SET("projectId = #{projectid,jdbcType=INTEGER}");
        }
        
        if (record.getImplday() != null) {
            SET("implDay = #{implday,jdbcType=INTEGER}");
        }
        
        if (record.getStafftype() != null) {
            SET("staffType = #{stafftype,jdbcType=INTEGER}");
        }
        
        if (record.getImplstafftotal() != null) {
            SET("implStaffTotal = #{implstafftotal,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}