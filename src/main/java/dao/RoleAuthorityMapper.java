package dao;

import entity.RoleAuthority;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RoleAuthorityMapper {
    @Delete({
        "delete from role_authority",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into role_authority (id, roleId, ",
        "authorityId)",
        "values (#{id,jdbcType=INTEGER}, #{roleid,jdbcType=INTEGER}, ",
        "#{authorityid,jdbcType=INTEGER})"
    })
    int insert(RoleAuthority record);

    @InsertProvider(type=RoleAuthoritySqlProvider.class, method="insertSelective")
    int insertSelective(RoleAuthority record);

    @Select({
        "select",
        "id, roleId, authorityId",
        "from role_authority",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="roleId", property="roleid", jdbcType=JdbcType.INTEGER),
        @Result(column="authorityId", property="authorityid", jdbcType=JdbcType.INTEGER)
    })
    RoleAuthority selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RoleAuthoritySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RoleAuthority record);

    @Update({
        "update role_authority",
        "set roleId = #{roleid,jdbcType=INTEGER},",
          "authorityId = #{authorityid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RoleAuthority record);
}