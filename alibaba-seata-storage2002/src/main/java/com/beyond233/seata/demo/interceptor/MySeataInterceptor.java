package com.beyond233.seata.demo.interceptor;

import io.seata.core.context.RootContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/12/26 1:23
 */
public class MySeataInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String rpcXid = request.getHeader(RootContext.KEY_XID);
        RootContext.bind(rpcXid);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String rpcXid = request.getHeader(RootContext.KEY_XID);
        String xid = RootContext.getXID();
        String unbindXid = RootContext.unbind();
    }
}
