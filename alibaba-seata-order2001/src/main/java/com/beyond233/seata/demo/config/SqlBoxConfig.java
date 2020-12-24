package com.beyond233.seata.demo.config;

import com.github.drinkjava2.jsqlbox.DbContext;
import com.github.drinkjava2.jtransactions.spring.SpringTxConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * todo
 *
 * @author XuJie
 * @date 2020/12/22 15:29
 */
@Configuration
public class SqlBoxConfig {

    @Resource
    private DataSource dataSource;

    @Bean
    public DbContext createDefaultDbContext() {
        DbContext ctx = new DbContext(dataSource);
        // 事务管理器
        ctx.setConnectionManager(SpringTxConnectionManager.instance());
        // 设定静态全局上下文，供ActiveRecord使用
        DbContext.setGlobalDbContext(ctx);
        ctx.setAllowShowSQL(true);
        return ctx;
    }
}
