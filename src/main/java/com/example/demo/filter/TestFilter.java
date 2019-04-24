package com.example.demo.filter;

import com.example.demo.util.LogUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器
 * 使用注解标注过滤器
 *
 * @WebFilter将一个实现了javax.servlet.Filter接口的类定义为过滤器 属性filterName声明过滤器的名称, 可选
 * 属性urlPatterns指定要过滤 的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 */
@WebFilter(urlPatterns = "/*")
public class TestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LogUtil.info("------TestFilter------init----------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LogUtil.info("------TestFilter------doFilter----------");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        LogUtil.info("------TestFilter------destroy----------");
    }
}
