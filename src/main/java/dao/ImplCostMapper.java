package dao;

import entity.ImplCost;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ImplCostMapper {
    @Delete({
        "delete from impl_cost",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into impl_cost (id, staffId, ",
        "implPlanId, projectId, ",
        "implDay, staffType, ",
        "implStaffTotal, description)",
        "values (#{id,jdbcType=INTEGER}, #{staffid,jdbcType=INTEGER}, ",
        "#{implplanid,jdbcType=INTEGER}, #{projectid,jdbcType=INTEGER}, ",
        "#{implday,jdbcType=INTEGER}, #{stafftype,jdbcType=INTEGER}, ",
        "#{implstafftotal,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR})"
    })
    int insert(ImplCost record);

    @InsertProvider(type=ImplCostSqlProvider.class, method="insertSelective")
    int insertSelective(ImplCost record);

    @Select({
        "select",
        "id, staffId, implPlanId, projectId, implDay, staffType, implStaffTotal, description",
        "from impl_cost",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="staffId", property="staffid", jdbcType=JdbcType.INTEGER),
        @Result(column="implPlanId", property="implplanid", jdbcType=JdbcType.INTEGER),
        @Result(column="projectId", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="implDay", property="implday", jdbcType=JdbcType.INTEGER),
        @Result(column="staffType", property="stafftype", jdbcType=JdbcType.INTEGER),
        @Result(column="implStaffTotal", property="implstafftotal", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    ImplCost selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ImplCostSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ImplCost record);

    @Update({
        "update impl_cost",
        "set staffId = #{staffid,jdbcType=INTEGER},",
          "implPlanId = #{implplanid,jdbcType=INTEGER},",
          "projectId = #{projectid,jdbcType=INTEGER},",
          "implDay = #{implday,jdbcType=INTEGER},",
          "staffType = #{stafftype,jdbcType=INTEGER},",
          "implStaffTotal = #{implstafftotal,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ImplCost record);
}