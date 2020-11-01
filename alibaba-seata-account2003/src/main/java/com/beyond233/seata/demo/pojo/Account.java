package com.beyond233.seata.demo.pojo;

import lombok.Data;

/**
 * 描述: 账户实体类
 *
 * @author beyond233
 * @since 2020/10/8 20:41
 */
@Data
public class Account {

    private Integer id;

    private String userId;

    private Integer money;
}
