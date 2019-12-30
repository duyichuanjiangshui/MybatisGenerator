package dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import entity.Order;

public class OrderSqlProvider {

    public String insertSelective(Order record) {
        BEGIN();
        INSERT_INTO("order");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getBudgetid() != null) {
            VALUES("budgetId", "#{budgetid,jdbcType=INTEGER}");
        }
        
        if (record.getBudgettotal() != null) {
            VALUES("budgetTotal", "#{budgettotal,jdbcType=INTEGER}");
        }
        
        if (record.getDiscount() != null) {
            VALUES("discount", "#{discount,jdbcType=DOUBLE}");
        }
        
        if (record.getPrepaid() != null) {
            VALUES("prepaid", "#{prepaid,jdbcType=INTEGER}");
        }
        
        if (record.getPaystate() != null) {
            VALUES("payState", "#{paystate,jdbcType=INTEGER}");
        }
        
        if (record.getPaymentmethod() != null) {
            VALUES("paymentMethod", "#{paymentmethod,jdbcType=INTEGER}");
        }
        
        if (record.getPaymenttotal() != null) {
            VALUES("paymentTotal", "#{paymenttotal,jdbcType=INTEGER}");
        }
        
        if (record.getCreatetime() != null) {
            VALUES("createTime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndtime() != null) {
            VALUES("endTime", "#{endtime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Order record) {
        BEGIN();
        UPDATE("order");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getBudgetid() != null) {
            SET("budgetId = #{budgetid,jdbcType=INTEGER}");
        }
        
        if (record.getBudgettotal() != null) {
            SET("budgetTotal = #{budgettotal,jdbcType=INTEGER}");
        }
        
        if (record.getDiscount() != null) {
            SET("discount = #{discount,jdbcType=DOUBLE}");
        }
        
        if (record.getPrepaid() != null) {
            SET("prepaid = #{prepaid,jdbcType=INTEGER}");
        }
        
        if (record.getPaystate() != null) {
            SET("payState = #{paystate,jdbcType=INTEGER}");
        }
        
        if (record.getPaymentmethod() != null) {
            SET("paymentMethod = #{paymentmethod,jdbcType=INTEGER}");
        }
        
        if (record.getPaymenttotal() != null) {
            SET("paymentTotal = #{paymenttotal,jdbcType=INTEGER}");
        }
        
        if (record.getCreatetime() != null) {
            SET("createTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndtime() != null) {
            SET("endTime = #{endtime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}