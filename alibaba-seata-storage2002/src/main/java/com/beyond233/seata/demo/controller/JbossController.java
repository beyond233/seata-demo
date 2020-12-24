package com.beyond233.seata.demo.controller;

import com.beyond233.seata.demo.dao.StorageDao;
import com.beyond233.seata.demo.pojo.Storage;
import com.beyond233.springcloud.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * todo
 *
 * @author XuJie
 * @date 2020/12/24 17:13
 */
@RestController
@Path("/storage")
public class JbossController {


    @Autowired
    private StorageDao storageDao;

    @POST
    @Path("/decrease")
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result decrease(@RequestBody Storage storage) {
        Integer result = storageDao.decrease(storage.getCommodityCode(), storage.getCount());
        return result == 1 ? Result.success(1) : Result.fail(0);
    }

}
