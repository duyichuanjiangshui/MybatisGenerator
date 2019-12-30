package dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import entity.HireHtCost;

public class HireHtCostSqlProvider {

    public String insertSelective(HireHtCost record) {
        BEGIN();
        INSERT_INTO("hire_ht_cost");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getHeavytoolid() != null) {
            VALUES("heavyToolId", "#{heavytoolid,jdbcType=INTEGER}");
        }
        
        if (record.getStarttime() != null) {
            VALUES("startTime", "#{starttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndtime() != null) {
            VALUES("endTime", "#{endtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSettlementtotal() != null) {
            VALUES("settlementTotal", "#{settlementtotal,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(HireHtCost record) {
        BEGIN();
        UPDATE("hire_ht_cost");
        
        if (record.getHeavytoolid() != null) {
            SET("heavyToolId = #{heavytoolid,jdbcType=INTEGER}");
        }
        
        if (record.getStarttime() != null) {
            SET("startTime = #{starttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndtime() != null) {
            SET("endTime = #{endtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSettlementtotal() != null) {
            SET("settlementTotal = #{settlementtotal,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}