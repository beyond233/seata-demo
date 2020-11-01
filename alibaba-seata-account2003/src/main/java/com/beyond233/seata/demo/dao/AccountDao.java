package com.beyond233.seata.demo.dao;

import com.github.drinkjava2.jdbpro.SqlItem;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;

import static com.github.drinkjava2.jsqlbox.DB.*;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/10/31 12:01
 */
@Repository
public class AccountDao {

    /**
     * 扣减余额
     *
     * @param userId 用户id
     * @param money 扣减的余额
     * @return  {@link Integer}
     * @author beyond233
     * @since 2020/10/31 12:14
     */
    public Integer decrease(String userId, Integer money) {
        money = getBalance(userId) - money;
        if (money < 0) {
            throw new RuntimeException();
        }
        return iUpdate("UPDATE account SET money=? WHERE user_id=?", param(money, userId));
    }

    /**
     * 获取余额
     *
     * @param userId 用户id
     * @return  {@link Integer}
     * @author beyond233
     * @since 2020/10/31 12:28
     */
    public Integer getBalance(String userId) {
        return iQueryForIntValue("SELECT money FROM account WHERE user_id=?", param(userId));
    }
}
