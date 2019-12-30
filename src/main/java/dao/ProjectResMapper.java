package dao;

import entity.ProjectRes;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ProjectResMapper {
    @Delete({
        "delete from project_res",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into project_res (id, projectId, ",
        "resId, resNum, description)",
        "values (#{id,jdbcType=INTEGER}, #{projectid,jdbcType=INTEGER}, ",
        "#{resid,jdbcType=INTEGER}, #{resnum,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR})"
    })
    int insert(ProjectRes record);

    @InsertProvider(type=ProjectResSqlProvider.class, method="insertSelective")
    int insertSelective(ProjectRes record);

    @Select({
        "select",
        "id, projectId, resId, resNum, description",
        "from project_res",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="projectId", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="resId", property="resid", jdbcType=JdbcType.INTEGER),
        @Result(column="resNum", property="resnum", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    ProjectRes selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ProjectResSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProjectRes record);

    @Update({
        "update project_res",
        "set projectId = #{projectid,jdbcType=INTEGER},",
          "resId = #{resid,jdbcType=INTEGER},",
          "resNum = #{resnum,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProjectRes record);
}