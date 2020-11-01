package com.beyond233.seata.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 描述: 启动类
 *
 * @author beyond233
 * @since 2020/10/8 17:35
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SeataOrder2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrder2001.class, args);
    }
}
