package com.beyond233.springcloud.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/10/8 21:26
 */
@Data
@Accessors(chain = true)
public class Storage {

    private Integer id;

    private String commodityCode;

    private Integer count;

}
