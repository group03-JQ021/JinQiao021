package com.jxdedu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
@WebFilter("/*")
public class EncodingFilter implements Filter {

    /**
     * 每一次请求都由doFilter方法拦截
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 设置响应的编码
        response.setContentType("text/html;charset=utf-8");

        HttpServletRequest req = (HttpServletRequest)request;
        if ("POST".equals(req.getMethod())){
            // 设置  post 方式请求的的编码
            request.setCharacterEncoding("utf-8");
            chain.doFilter(request,response);
        }else{
            MyRequest myreq = new MyRequest(req);
            chain.doFilter(myreq,response);
        }
        
        
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("注解方式添加的过滤器");
    }

}

