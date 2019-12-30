package dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import entity.ProjectDep;

public class ProjectDepSqlProvider {

    public String insertSelective(ProjectDep record) {
        BEGIN();
        INSERT_INTO("project_dep");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getProjectid() != null) {
            VALUES("projectId", "#{projectid,jdbcType=INTEGER}");
        }
        
        if (record.getDepid() != null) {
            VALUES("depId", "#{depid,jdbcType=INTEGER}");
        }
        
        if (record.getDepstaffnum() != null) {
            VALUES("depStaffNum", "#{depstaffnum,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ProjectDep record) {
        BEGIN();
        UPDATE("project_dep");
        
        if (record.getProjectid() != null) {
            SET("projectId = #{projectid,jdbcType=INTEGER}");
        }
        
        if (record.getDepid() != null) {
            SET("depId = #{depid,jdbcType=INTEGER}");
        }
        
        if (record.getDepstaffnum() != null) {
            SET("depStaffNum = #{depstaffnum,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}