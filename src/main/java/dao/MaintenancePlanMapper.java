package dao;

import entity.MaintenancePlan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MaintenancePlanMapper {
    @Delete({
        "delete from maintenance_plan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into maintenance_plan (id, projectId, ",
        "startTime, expectedEndTime, ",
        "actualEndTime, groupId, ",
        "purpose, planState, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{projectid,jdbcType=INTEGER}, ",
        "#{starttime,jdbcType=TIMESTAMP}, #{expectedendtime,jdbcType=TIMESTAMP}, ",
        "#{actualendtime,jdbcType=TIMESTAMP}, #{groupid,jdbcType=INTEGER}, ",
        "#{purpose,jdbcType=VARCHAR}, #{planstate,jdbcType=INTEGER}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(MaintenancePlan record);

    @InsertProvider(type=MaintenancePlanSqlProvider.class, method="insertSelective")
    int insertSelective(MaintenancePlan record);

    @Select({
        "select",
        "id, projectId, startTime, expectedEndTime, actualEndTime, groupId, purpose, ",
        "planState, description",
        "from maintenance_plan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="projectId", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="startTime", property="starttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="expectedEndTime", property="expectedendtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="actualEndTime", property="actualendtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="groupId", property="groupid", jdbcType=JdbcType.INTEGER),
        @Result(column="purpose", property="purpose", jdbcType=JdbcType.VARCHAR),
        @Result(column="planState", property="planstate", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    MaintenancePlan selectByPrimaryKey(Integer id);

    @UpdateProvider(type=MaintenancePlanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MaintenancePlan record);

    @Update({
        "update maintenance_plan",
        "set projectId = #{projectid,jdbcType=INTEGER},",
          "startTime = #{starttime,jdbcType=TIMESTAMP},",
          "expectedEndTime = #{expectedendtime,jdbcType=TIMESTAMP},",
          "actualEndTime = #{actualendtime,jdbcType=TIMESTAMP},",
          "groupId = #{groupid,jdbcType=INTEGER},",
          "purpose = #{purpose,jdbcType=VARCHAR},",
          "planState = #{planstate,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MaintenancePlan record);
}