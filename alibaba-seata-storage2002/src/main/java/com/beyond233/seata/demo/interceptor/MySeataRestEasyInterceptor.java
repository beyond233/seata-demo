package com.beyond233.seata.demo.interceptor;

import io.seata.core.context.RootContext;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpRequestPreprocessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import java.io.IOException;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/12/26 16:22
 */

public class MySeataRestEasyInterceptor implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String rpcXid = containerRequestContext.getHeaderString(RootContext.KEY_XID);
        String xid = RootContext.getXID();
        if (xid == null && rpcXid != null) {
            RootContext.bind(rpcXid);
        }
    }

}
