package com.beyond233.seata.demo.rpc;

import com.beyond233.springcloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述: 库存rpc
 *
 * @author beyond233
 * @since 2020/10/8 19:46
 */
@Service
@FeignClient("alibaba-seata-storage")
public interface StorageRpc {

    @PostMapping("/storage/decrease")
    Result decrease(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);
}
