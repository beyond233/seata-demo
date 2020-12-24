package com.beyond233.seata.demo.rpc;

import com.beyond233.springcloud.entity.Result;
import com.beyond233.springcloud.entity.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * todo
 *
 * @author beyond233
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

    public void decreaseByJboss(String commodityCode, Integer count) {
        Storage storage = new Storage().setCommodityCode(commodityCode).setCount(count);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Accpet-Encoding", "gzip");
        headers.add("Content-Encoding", "UTF-8");
        headers.add("Content-Type", "application/json; charset=UTF-8");
        HttpEntity<Object> httpEntity = new HttpEntity<>(storage, headers);
        template.postForEntity("http://alibaba-seata-storage/storage/decrease/jboss", httpEntity, Result.class);
    }
}
