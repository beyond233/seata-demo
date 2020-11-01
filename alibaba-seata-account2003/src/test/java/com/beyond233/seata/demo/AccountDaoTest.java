package com.beyond233.seata.demo;

import com.beyond233.seata.demo.dao.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/10/31 12:30
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountDaoTest {

    @Autowired
    private AccountDao accountDao;

    @Test
    public void decrease() {
        accountDao.getBalance("1");
    }
}
