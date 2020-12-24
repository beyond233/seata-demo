package com.beyond233.seata.demo.config;

import com.github.drinkjava2.jsqlbox.DbContext;
import com.github.drinkjava2.jtransactions.spring.SpringTxConnectionManager;
import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * 描述:  数据源代理配置,用seata来代理数据源进行分布式事务的管理
 *
 * @author beyond233
 * @since 2020/10/8 20:22
 */
//@Configuration
public class DataSourceProxyConfig {

    /**
     * 构建Hikari数据源
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource hikariDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        return hikariDataSource;
    }

    /**
     * seata代理Hikari数据源
     */
    @Bean
    public DataSourceProxy dataSourceProxy(@Qualifier("hikariDataSource") DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }


    /**
     * 设置jSqlBox数据源为seata代理数据源
     */
    @Bean
    public DbContext createDefaultDbContext(DataSourceProxy dataSourceProxy) {
        DbContext ctx = new DbContext(dataSourceProxy);
        // 事务管理器
        ctx.setConnectionManager(SpringTxConnectionManager.instance());
        // 设定静态全局上下文，供ActiveRecord使用
        DbContext.setGlobalDbContext(ctx);
        ctx.setAllowShowSQL(true);
        return ctx;
    }


}
