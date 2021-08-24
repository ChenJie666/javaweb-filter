package com.cj.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author CJ
 * @date 2021/7/13 16:57
 */
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        System.out.println("执行过滤器前");
        chain.doFilter(request,response);
        System.out.println("执行过滤器后");
    }

    @Override
    public void destroy() {
        System.gc();
        System.out.println("销毁过滤器");
    }
}
