package dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import entity.ResPurchase;

public class ResPurchaseSqlProvider {

    public String insertSelective(ResPurchase record) {
        BEGIN();
        INSERT_INTO("res_purchase");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPurtime() != null) {
            VALUES("purTime", "#{purtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPurnum() != null) {
            VALUES("purNum", "#{purnum,jdbcType=INTEGER}");
        }
        
        if (record.getUnitprice() != null) {
            VALUES("unitPrice", "#{unitprice,jdbcType=INTEGER}");
        }
        
        if (record.getDiscount() != null) {
            VALUES("discount", "#{discount,jdbcType=DOUBLE}");
        }
        
        if (record.getResid() != null) {
            VALUES("resId", "#{resid,jdbcType=INTEGER}");
        }
        
        if (record.getSupplierid() != null) {
            VALUES("supplierId", "#{supplierid,jdbcType=INTEGER}");
        }
        
        if (record.getBuyerid() != null) {
            VALUES("buyerId", "#{buyerid,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ResPurchase record) {
        BEGIN();
        UPDATE("res_purchase");
        
        if (record.getPurtime() != null) {
            SET("purTime = #{purtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPurnum() != null) {
            SET("purNum = #{purnum,jdbcType=INTEGER}");
        }
        
        if (record.getUnitprice() != null) {
            SET("unitPrice = #{unitprice,jdbcType=INTEGER}");
        }
        
        if (record.getDiscount() != null) {
            SET("discount = #{discount,jdbcType=DOUBLE}");
        }
        
        if (record.getResid() != null) {
            SET("resId = #{resid,jdbcType=INTEGER}");
        }
        
        if (record.getSupplierid() != null) {
            SET("supplierId = #{supplierid,jdbcType=INTEGER}");
        }
        
        if (record.getBuyerid() != null) {
            SET("buyerId = #{buyerid,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}