package com.jxdedu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 登录控制过滤器
* @ClassName SecurityFilter
* @author ChenXizhan
* @date 2018年6月11日
* @Description ch11 - 课后作业
 */
public class SecurityFilter implements Filter {

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
        System.out.println("login filter:");
        
        String path = req.getServletPath();
        
        if (req.getSession().getAttribute("userName") == null &&
                !"/login.jsp".equals(path) &&
                !"/LoginServlet".equals(path)){
            System.out.println("block it:" + path);
            ((HttpServletResponse) response).sendRedirect(req.getContextPath()+"/login.jsp");
        }else{
            System.out.println("let it go:" + path);
            chain.doFilter(request,response);
        }
//        chain.doFilter(request,response);
    }

   /**
    * 初始化,只在出生的时候执行一次
    */
    @Override
    public void init(FilterConfig config) throws ServletException {
        
    }

}
