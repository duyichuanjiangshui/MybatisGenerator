package dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import entity.Authority;

public class AuthoritySqlProvider {

    public String insertSelective(Authority record) {
        BEGIN();
        INSERT_INTO("authority");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getAuthname() != null) {
            VALUES("authName", "#{authname,jdbcType=VARCHAR}");
        }
        
        if (record.getResname() != null) {
            VALUES("resName", "#{resname,jdbcType=VARCHAR}");
        }
        
        if (record.getRestype() != null) {
            VALUES("resType", "#{restype,jdbcType=INTEGER}");
        }
        
        if (record.getUrl() != null) {
            VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getParentid() != null) {
            VALUES("parentId", "#{parentid,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Authority record) {
        BEGIN();
        UPDATE("authority");
        
        if (record.getAuthname() != null) {
            SET("authName = #{authname,jdbcType=VARCHAR}");
        }
        
        if (record.getResname() != null) {
            SET("resName = #{resname,jdbcType=VARCHAR}");
        }
        
        if (record.getRestype() != null) {
            SET("resType = #{restype,jdbcType=INTEGER}");
        }
        
        if (record.getUrl() != null) {
            SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            SET("icon = #{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getParentid() != null) {
            SET("parentId = #{parentid,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}