package dao;

import entity.Authority;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AuthorityMapper {
    @Delete({
        "delete from authority",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into authority (id, authName, ",
        "resName, resType, ",
        "url, icon, parentId, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{authname,jdbcType=VARCHAR}, ",
        "#{resname,jdbcType=VARCHAR}, #{restype,jdbcType=INTEGER}, ",
        "#{url,jdbcType=VARCHAR}, #{icon,jdbcType=VARCHAR}, #{parentid,jdbcType=INTEGER}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(Authority record);

    @InsertProvider(type=AuthoritySqlProvider.class, method="insertSelective")
    int insertSelective(Authority record);

    @Select({
        "select",
        "id, authName, resName, resType, url, icon, parentId, description",
        "from authority",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="authName", property="authname", jdbcType=JdbcType.VARCHAR),
        @Result(column="resName", property="resname", jdbcType=JdbcType.VARCHAR),
        @Result(column="resType", property="restype", jdbcType=JdbcType.INTEGER),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="parentId", property="parentid", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    Authority selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AuthoritySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Authority record);

    @Update({
        "update authority",
        "set authName = #{authname,jdbcType=VARCHAR},",
          "resName = #{resname,jdbcType=VARCHAR},",
          "resType = #{restype,jdbcType=INTEGER},",
          "url = #{url,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "parentId = #{parentid,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Authority record);
}