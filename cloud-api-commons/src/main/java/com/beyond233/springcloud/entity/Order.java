package com.beyond233.springcloud.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 描述: 订单实体类
 *
 * @author beyond233
 * @since 2020/10/8 17:36
 */
@Data
@Accessors(chain = true)
//@Entity
//@Table(name = "order") //指定和哪个数据库表对应，入宫省略不写默认表明就是类名小写
public class Order {

    /**
     * id
     * */
//    @Id
//    @Column(length = 11)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     * */
//    @Column(columnDefinition = "用户id")
    private String userId;

    /**
     * 商品码
     * */
//    @Column(columnDefinition = "商品码")
    private String commodityCode;

    /**
     * 数量
     * */
//    @Column(length = 11,columnDefinition = "数量")
    private Integer count;

    /**
     * 金额
     * */
//    @Column(length = 11,columnDefinition = "金额")
    private Integer money;

    /**
     * 状态：0-未完成；1-完成
     * */
//    @Column(length = 1)
    private Integer status;
}
