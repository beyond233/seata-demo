package com.beyond233.seata.demo.rpc;

import com.beyond233.springcloud.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * todo
 *
 * @author XuJie
 * @date 2020/12/24 16:33
 */
@Service
public class AccountRestRpc {
    @Autowired
    private RestTemplate template;

    public void decrease(String userId, Integer money) {
        template.postForEntity("http://alibaba-seata-account/account/decrease?userId={userId}&money={money}", null, Result.class, userId, money);
    }
}
