package dao;

import entity.Client;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ClientMapper {
    @Delete({
        "delete from client",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into client (id, name, ",
        "company, address, ",
        "phone, creditRating, ",
        "comment, description)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{company,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{creditrating,jdbcType=INTEGER}, ",
        "#{comment,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR})"
    })
    int insert(Client record);

    @InsertProvider(type=ClientSqlProvider.class, method="insertSelective")
    int insertSelective(Client record);

    @Select({
        "select",
        "id, name, company, address, phone, creditRating, comment, description",
        "from client",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="creditRating", property="creditrating", jdbcType=JdbcType.INTEGER),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    Client selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ClientSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Client record);

    @Update({
        "update client",
        "set name = #{name,jdbcType=VARCHAR},",
          "company = #{company,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "creditRating = #{creditrating,jdbcType=INTEGER},",
          "comment = #{comment,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Client record);
}