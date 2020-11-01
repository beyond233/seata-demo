package com.beyond233.seata.demo.dao;

import com.beyond233.seata.demo.pojo.Order;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Repository;

import javax.print.attribute.standard.OrientationRequested;

import static com.github.drinkjava2.jdbpro.JDBPRO.param;
import static com.github.drinkjava2.jsqlbox.DB.iInsert;
import static com.github.drinkjava2.jsqlbox.DB.iUpdate;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/11/1 22:24
 */
@Repository
public class OrderDao {

    /**
     * 创建订单
     *
     * @param order 订单信息
     * @author beyond233
     * @since 2020/11/1 22:29
     */
    public Integer create(Order order) {
        return iInsert(new ScalarHandler<Number>(),
                "INSERT INTO `order`(user_id,commodity_code,count,money,`status`) VALUE(?,?,?,?,0)",
                param(order.getUserId(), order.getCommodityCode(), order.getCount(), order.getMoney()));
    }

    /**
     * 更新订单状态
     *
     * @param orderId  id
     * @param status  状态
     * @return  {@link Integer}
     * @author beyond233
     * @since 2020/11/1 22:31
     */
    public Integer updateOrder(Integer orderId, Integer status) {
        return iUpdate("UPDATE order SET status=? where order_id=?", param(status, orderId));
    }

}
