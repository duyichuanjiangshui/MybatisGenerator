package dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import entity.UserRole;

public class UserRoleSqlProvider {

    public String insertSelective(UserRole record) {
        BEGIN();
        INSERT_INTO("user_role");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserid() != null) {
            VALUES("userId", "#{userid,jdbcType=INTEGER}");
        }
        
        if (record.getRoleid() != null) {
            VALUES("roleId", "#{roleid,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(UserRole record) {
        BEGIN();
        UPDATE("user_role");
        
        if (record.getUserid() != null) {
            SET("userId = #{userid,jdbcType=INTEGER}");
        }
        
        if (record.getRoleid() != null) {
            SET("roleId = #{roleid,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}