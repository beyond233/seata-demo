package com.beyond233.seata.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 描述: SeataStorage2002启动类
 *
 * @author beyond233
 * @since 2020/10/8 21:06
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SeataStorage2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorage2002.class, args);
    }
}