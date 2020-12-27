package com.beyond233.seata.demo.config;

import com.beyond233.seata.demo.interceptor.MySeataRestEasyInterceptor;
import org.jboss.resteasy.core.AsynchronousDispatcher;
import org.jboss.resteasy.core.interception.ContainerRequestFilterRegistry;
import org.jboss.resteasy.core.interception.LegacyPrecedence;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/12/27 22:35
 */
@Configuration
public class RestEasyinterceptorConfig {

    @Bean
    public MySeataRestEasyInterceptor mySeataRestEasyInterceptor() {
        return new MySeataRestEasyInterceptor();
    }


}
