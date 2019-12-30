package dao;

import entity.ResSchPlan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ResSchPlanMapper {
    @Delete({
        "delete from res_sch_plan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into res_sch_plan (id, implPlanId, ",
        "resId, resNum, planState, ",
        "allocatedTime, description)",
        "values (#{id,jdbcType=INTEGER}, #{implplanid,jdbcType=INTEGER}, ",
        "#{resid,jdbcType=INTEGER}, #{resnum,jdbcType=INTEGER}, #{planstate,jdbcType=INTEGER}, ",
        "#{allocatedtime,jdbcType=TIMESTAMP}, #{description,jdbcType=VARCHAR})"
    })
    int insert(ResSchPlan record);

    @InsertProvider(type=ResSchPlanSqlProvider.class, method="insertSelective")
    int insertSelective(ResSchPlan record);

    @Select({
        "select",
        "id, implPlanId, resId, resNum, planState, allocatedTime, description",
        "from res_sch_plan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="implPlanId", property="implplanid", jdbcType=JdbcType.INTEGER),
        @Result(column="resId", property="resid", jdbcType=JdbcType.INTEGER),
        @Result(column="resNum", property="resnum", jdbcType=JdbcType.INTEGER),
        @Result(column="planState", property="planstate", jdbcType=JdbcType.INTEGER),
        @Result(column="allocatedTime", property="allocatedtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    ResSchPlan selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ResSchPlanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ResSchPlan record);

    @Update({
        "update res_sch_plan",
        "set implPlanId = #{implplanid,jdbcType=INTEGER},",
          "resId = #{resid,jdbcType=INTEGER},",
          "resNum = #{resnum,jdbcType=INTEGER},",
          "planState = #{planstate,jdbcType=INTEGER},",
          "allocatedTime = #{allocatedtime,jdbcType=TIMESTAMP},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ResSchPlan record);
}