package com.beyond233.seata.demo.rpc;

import com.beyond233.springcloud.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * todo
 *
 * @author XuJie
 * @date 2020/12/24 16:42
 */
@Service
public class StorageRestRpc {

    @Autowired
    private RestTemplate template;

    public void decrease(String commodityCode, Integer count) {
        template.postForEntity("http://alibaba-seata-storage/storage/decrease?commodityCode={commodityCode}&count={count}",
                null, Result.class, commodityCode, count);
    }

    public void decreaseForJboss(String commodityCode, Integer count) {
        template.postForEntity("http://alibaba-seata-storage/storage/decrease?commodityCode={commodityCode}&count={count}",
                null, Result.class, commodityCode, count);
    }
}
