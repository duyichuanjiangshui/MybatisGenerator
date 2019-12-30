package dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import entity.ResourceCost;

public class ResourceCostSqlProvider {

    public String insertSelective(ResourceCost record) {
        BEGIN();
        INSERT_INTO("resource_cost");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPlanid() != null) {
            VALUES("planId", "#{planid,jdbcType=INTEGER}");
        }
        
        if (record.getResid() != null) {
            VALUES("resId", "#{resid,jdbcType=INTEGER}");
        }
        
        if (record.getResnum() != null) {
            VALUES("resNum", "#{resnum,jdbcType=INTEGER}");
        }
        
        if (record.getRestotal() != null) {
            VALUES("resTotal", "#{restotal,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ResourceCost record) {
        BEGIN();
        UPDATE("resource_cost");
        
        if (record.getPlanid() != null) {
            SET("planId = #{planid,jdbcType=INTEGER}");
        }
        
        if (record.getResid() != null) {
            SET("resId = #{resid,jdbcType=INTEGER}");
        }
        
        if (record.getResnum() != null) {
            SET("resNum = #{resnum,jdbcType=INTEGER}");
        }
        
        if (record.getRestotal() != null) {
            SET("resTotal = #{restotal,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}