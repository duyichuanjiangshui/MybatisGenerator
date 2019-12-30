package dao;

import entity.ResPurchase;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ResPurchaseMapper {
    @Delete({
        "delete from res_purchase",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into res_purchase (id, purTime, ",
        "purNum, unitPrice, ",
        "discount, resId, ",
        "supplierId, buyerId)",
        "values (#{id,jdbcType=INTEGER}, #{purtime,jdbcType=TIMESTAMP}, ",
        "#{purnum,jdbcType=INTEGER}, #{unitprice,jdbcType=INTEGER}, ",
        "#{discount,jdbcType=DOUBLE}, #{resid,jdbcType=INTEGER}, ",
        "#{supplierid,jdbcType=INTEGER}, #{buyerid,jdbcType=INTEGER})"
    })
    int insert(ResPurchase record);

    @InsertProvider(type=ResPurchaseSqlProvider.class, method="insertSelective")
    int insertSelective(ResPurchase record);

    @Select({
        "select",
        "id, purTime, purNum, unitPrice, discount, resId, supplierId, buyerId",
        "from res_purchase",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="purTime", property="purtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="purNum", property="purnum", jdbcType=JdbcType.INTEGER),
        @Result(column="unitPrice", property="unitprice", jdbcType=JdbcType.INTEGER),
        @Result(column="discount", property="discount", jdbcType=JdbcType.DOUBLE),
        @Result(column="resId", property="resid", jdbcType=JdbcType.INTEGER),
        @Result(column="supplierId", property="supplierid", jdbcType=JdbcType.INTEGER),
        @Result(column="buyerId", property="buyerid", jdbcType=JdbcType.INTEGER)
    })
    ResPurchase selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ResPurchaseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ResPurchase record);

    @Update({
        "update res_purchase",
        "set purTime = #{purtime,jdbcType=TIMESTAMP},",
          "purNum = #{purnum,jdbcType=INTEGER},",
          "unitPrice = #{unitprice,jdbcType=INTEGER},",
          "discount = #{discount,jdbcType=DOUBLE},",
          "resId = #{resid,jdbcType=INTEGER},",
          "supplierId = #{supplierid,jdbcType=INTEGER},",
          "buyerId = #{buyerid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ResPurchase record);
}