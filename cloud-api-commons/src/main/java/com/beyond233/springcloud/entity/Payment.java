package com.beyond233.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>项目文档: 订单</p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-06-06 18:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment implements Serializable {

    private Long id;
    /**流水号*/
    private String serial;

}
