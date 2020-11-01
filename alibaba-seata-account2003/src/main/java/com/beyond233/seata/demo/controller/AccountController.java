package com.beyond233.seata.demo.controller;

import com.beyond233.seata.demo.dao.AccountDao;
import com.beyond233.springcloud.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/10/8 21:12
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountDao accountDao;

    @PostMapping("/decrease")
    public Result decrease(@RequestParam("userId") String userId, @RequestParam("money") Integer money) {
        return accountDao.decrease(userId, money) == 1 ? Result.success(1) : Result.fail(0);
    }

    @GetMapping("/balance")
    public Integer getBalance() {
        return accountDao.getBalance("1");
    }
}
