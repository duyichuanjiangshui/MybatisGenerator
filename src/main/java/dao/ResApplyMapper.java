package dao;

import entity.ResApply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ResApplyMapper {
    @Delete({
        "delete from res_apply",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into res_apply (id, applyTime, ",
        "auditState, applierId, ",
        "resId, resNum, purpose, ",
        "implPlanId, resAllocatedTime, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{applytime,jdbcType=TIMESTAMP}, ",
        "#{auditstate,jdbcType=INTEGER}, #{applierid,jdbcType=INTEGER}, ",
        "#{resid,jdbcType=INTEGER}, #{resnum,jdbcType=INTEGER}, #{purpose,jdbcType=VARCHAR}, ",
        "#{implplanid,jdbcType=INTEGER}, #{resallocatedtime,jdbcType=TIMESTAMP}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(ResApply record);

    @InsertProvider(type=ResApplySqlProvider.class, method="insertSelective")
    int insertSelective(ResApply record);

    @Select({
        "select",
        "id, applyTime, auditState, applierId, resId, resNum, purpose, implPlanId, resAllocatedTime, ",
        "description",
        "from res_apply",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="applyTime", property="applytime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="auditState", property="auditstate", jdbcType=JdbcType.INTEGER),
        @Result(column="applierId", property="applierid", jdbcType=JdbcType.INTEGER),
        @Result(column="resId", property="resid", jdbcType=JdbcType.INTEGER),
        @Result(column="resNum", property="resnum", jdbcType=JdbcType.INTEGER),
        @Result(column="purpose", property="purpose", jdbcType=JdbcType.VARCHAR),
        @Result(column="implPlanId", property="implplanid", jdbcType=JdbcType.INTEGER),
        @Result(column="resAllocatedTime", property="resallocatedtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    ResApply selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ResApplySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ResApply record);

    @Update({
        "update res_apply",
        "set applyTime = #{applytime,jdbcType=TIMESTAMP},",
          "auditState = #{auditstate,jdbcType=INTEGER},",
          "applierId = #{applierid,jdbcType=INTEGER},",
          "resId = #{resid,jdbcType=INTEGER},",
          "resNum = #{resnum,jdbcType=INTEGER},",
          "purpose = #{purpose,jdbcType=VARCHAR},",
          "implPlanId = #{implplanid,jdbcType=INTEGER},",
          "resAllocatedTime = #{resallocatedtime,jdbcType=TIMESTAMP},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ResApply record);
}