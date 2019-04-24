package com.example.demo.listener;

import com.example.demo.util.LogUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听器
 * 使用@WebListener注解，实现ServletContextListener接口
 */
@WebListener
public class TestServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LogUtil.info("------TestServletContextListener------contextInitialized----------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LogUtil.info("------TestServletContextListener------contextDestroyed----------");
    }
}
