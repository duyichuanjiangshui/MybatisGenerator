package dao;

import entity.Attendance;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AttendanceMapper {
    @Delete({
        "delete from attendance",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into attendance (id, startTime, ",
        "endTime, staffId, ",
        "staffType, attendanceState, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{starttime,jdbcType=TIMESTAMP}, ",
        "#{endtime,jdbcType=TIMESTAMP}, #{staffid,jdbcType=INTEGER}, ",
        "#{stafftype,jdbcType=INTEGER}, #{attendancestate,jdbcType=INTEGER}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(Attendance record);

    @InsertProvider(type=AttendanceSqlProvider.class, method="insertSelective")
    int insertSelective(Attendance record);

    @Select({
        "select",
        "id, startTime, endTime, staffId, staffType, attendanceState, description",
        "from attendance",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="startTime", property="starttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="endTime", property="endtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="staffId", property="staffid", jdbcType=JdbcType.INTEGER),
        @Result(column="staffType", property="stafftype", jdbcType=JdbcType.INTEGER),
        @Result(column="attendanceState", property="attendancestate", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    Attendance selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AttendanceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Attendance record);

    @Update({
        "update attendance",
        "set startTime = #{starttime,jdbcType=TIMESTAMP},",
          "endTime = #{endtime,jdbcType=TIMESTAMP},",
          "staffId = #{staffid,jdbcType=INTEGER},",
          "staffType = #{stafftype,jdbcType=INTEGER},",
          "attendanceState = #{attendancestate,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Attendance record);
}