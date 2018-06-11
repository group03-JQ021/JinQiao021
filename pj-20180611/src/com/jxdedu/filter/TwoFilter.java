package com.jxdedu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TwoFilter implements Filter {

    /**
     * 每一次请求都由doFilter方法拦截
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("filter-02");
        
        // 方行请求; 若无此语句,则此请求就此被拦截.
        chain.doFilter(request,response);
        System.out.println("I'am second filter, 我在何时被输出呢?");
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
