package com.beyond233.seata.demo.dao;

import com.github.drinkjava2.jdbpro.JDBPRO;
import com.github.drinkjava2.jsqlbox.DB;
import org.springframework.stereotype.Repository;

import static com.github.drinkjava2.jsqlbox.DB.iQueryForIntValue;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/11/1 22:35
 */
@Repository
public class StorageDao {


    public Integer decrease(String commodityCode, Integer count) {
        count = getBalance(commodityCode) - count;
        if (count < 0) {
            throw new RuntimeException();
        }
        return DB.iUpdate("UPDATE storage SET count =? WHERE commodity_code=?", JDBPRO.param(count, commodityCode));
    }

    public Integer getBalance(String commodityCode) {
        return iQueryForIntValue("SELECT count FROM storage WHERE commodity_code=?", JDBPRO.param(commodityCode));
    }
}
