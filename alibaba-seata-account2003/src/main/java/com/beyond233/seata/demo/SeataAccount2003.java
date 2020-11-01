package com.beyond233.seata.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/10/8 20:39
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SeataAccount2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccount2003.class, args);
    }
}
