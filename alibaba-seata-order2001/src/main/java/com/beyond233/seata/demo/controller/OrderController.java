package com.beyond233.seata.demo.controller;

import com.beyond233.seata.demo.pojo.Order;
import com.beyond233.seata.demo.service.OrderService;
import com.beyond233.springcloud.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/10/8 18:36
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Result<Order> getOrder(@RequestBody Order order){
        orderService.create(order);
        return Result.success(order);
    }

    @PostMapping("/create/jboss")
    public Result<Order> getOrderByJboss(@RequestBody Order order){
        orderService.createByJboss(order);
        return Result.success(order);
    }
}
