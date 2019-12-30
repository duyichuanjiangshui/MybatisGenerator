package dao;

import entity.ProjectDep;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ProjectDepMapper {
    @Delete({
        "delete from project_dep",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into project_dep (id, projectId, ",
        "depId, depStaffNum, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{projectid,jdbcType=INTEGER}, ",
        "#{depid,jdbcType=INTEGER}, #{depstaffnum,jdbcType=INTEGER}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(ProjectDep record);

    @InsertProvider(type=ProjectDepSqlProvider.class, method="insertSelective")
    int insertSelective(ProjectDep record);

    @Select({
        "select",
        "id, projectId, depId, depStaffNum, description",
        "from project_dep",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="projectId", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="depId", property="depid", jdbcType=JdbcType.INTEGER),
        @Result(column="depStaffNum", property="depstaffnum", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    ProjectDep selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ProjectDepSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProjectDep record);

    @Update({
        "update project_dep",
        "set projectId = #{projectid,jdbcType=INTEGER},",
          "depId = #{depid,jdbcType=INTEGER},",
          "depStaffNum = #{depstaffnum,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProjectDep record);
}