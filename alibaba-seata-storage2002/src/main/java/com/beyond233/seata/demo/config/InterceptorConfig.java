package com.beyond233.seata.demo.config;

import com.beyond233.seata.demo.interceptor.SeataInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 描述: 拦截器配置
 *
 * @author beyond233
 * @since 2020/11/15 0:44
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 添加JWT拦截器
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SeataInterceptor())
                .addPathPatterns("/**");
    }
}
