package com.jxdedu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class OneFilter implements Filter {

    @Override
    public void destroy() {
    }

    /**
     * 每一次请求都由doFilter方法拦截
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
//        System.out.println("filter-01:我是处理过滤的,每次请求,我都会被执行.");
////        response.getWriter().print("no no no");
//        
//        // 方行请求; 若无此语句,则此请求就此被拦截.
//        chain.doFilter(request,response);
//        System.out.println("I'am first filter, 我在何时被输出呢?");
        System.out.println("path info:"+req.getPathInfo());
        System.out.println("req uri:  "+req.getRequestURI());
        System.out.println("servlet path: " + req.getServletPath());
        System.out.println("path translated:" + req.getPathTranslated());
        chain.doFilter(request,response);
    }

   /**
    * 初始化,只在出生的时候执行一次
    */
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("我是第一个过滤器,我随服务器的启动而实例化; 我随过滤器的实例化而执行,只执行一次");
        String enc = config.getInitParameter("encoding");
        String name = config.getInitParameter("name");
        String filterName = config.getFilterName();
        ServletContext sc = config.getServletContext();
        String realPath = sc.getRealPath("/*");
        String path = sc.getContextPath();
        
        
        System.out.println("encoding:"+enc);
        System.out.println("name:"+  name);
        System.out.println("filter-name:"+filterName);
        System.out.println("real path of /*:"+ realPath);
        System.out.println("context path:"+ path);
    }

}
