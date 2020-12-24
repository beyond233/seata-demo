package com.beyond233.seata.demo.controller;

import com.beyond233.seata.demo.dao.StorageDao;
import com.beyond233.springcloud.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述: StorageController 控制器类
 *
 * @author beyond233
 * @since 2020/10/8 21:38
 */
@RestController
@RequestMapping("/storage")
@Slf4j(topic = "库存服务")
public class StorageController {

    @Autowired
    private StorageDao storageDao;

    @PostMapping("/decrease")
    public Result decrease(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count) {
        Integer result = storageDao.decrease(commodityCode, count);
        return result == 1 ? Result.success(1) : Result.fail(0);
    }

}

