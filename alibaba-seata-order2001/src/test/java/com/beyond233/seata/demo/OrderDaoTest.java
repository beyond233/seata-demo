package com.beyond233.seata.demo;

import com.beyond233.seata.demo.dao.OrderDao;
import com.beyond233.seata.demo.pojo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/11/1 23:07
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDaoTest {

    @Autowired
    private OrderDao dao;

    @Test
    public void test() {
        Order order = new Order()
                .setCommodityCode("999")
                .setCount(999)
                .setMoney(999)
                .setStatus(0)
                .setUserId("999");
        dao.create(order);
    }
}

