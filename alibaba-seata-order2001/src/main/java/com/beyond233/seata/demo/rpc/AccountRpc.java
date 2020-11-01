package com.beyond233.seata.demo.rpc;

import com.beyond233.springcloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述: 账户rpc
 *
 * @author beyond233
 * @since 2020/10/8 19:44
 */
@Service
@FeignClient("alibaba-seata-account")
public interface AccountRpc {

    @PostMapping("/account/decrease")
    Result decrease(@RequestParam("userId") String userId, @RequestParam("money") Integer money);



}
