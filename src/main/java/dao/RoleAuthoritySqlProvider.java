package dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import entity.RoleAuthority;

public class RoleAuthoritySqlProvider {

    public String insertSelective(RoleAuthority record) {
        BEGIN();
        INSERT_INTO("role_authority");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getRoleid() != null) {
            VALUES("roleId", "#{roleid,jdbcType=INTEGER}");
        }
        
        if (record.getAuthorityid() != null) {
            VALUES("authorityId", "#{authorityid,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(RoleAuthority record) {
        BEGIN();
        UPDATE("role_authority");
        
        if (record.getRoleid() != null) {
            SET("roleId = #{roleid,jdbcType=INTEGER}");
        }
        
        if (record.getAuthorityid() != null) {
            SET("authorityId = #{authorityid,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}