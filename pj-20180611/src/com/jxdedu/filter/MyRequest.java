package com.jxdedu.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {
    // 1. 定义被装饰的对象
    private HttpServletRequest request;

    // 2. 提供一个实例化request的构造方法
    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }
    
    @Override
    public String getParameter(String name){
        // get 方式获取数据的默认编码是 iso-8859-1
        String value = request.getParameter(name);
        try{
            value = new String(value.getBytes("iso-8859-1"),"utf-8");
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return value;
    }

}
