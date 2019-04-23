package com.example.demo.listener;

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
        System.out.println("------TestServletContextListener------contextInitialized----------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("------TestServletContextListener------contextDestroyed----------");
    }
}
