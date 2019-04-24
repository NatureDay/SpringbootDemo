package com.example.demo.listener;

import com.example.demo.util.LogUtil;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听Session的创建与销毁
 */
@WebListener
public class TestHttpSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        LogUtil.info("------TestHttpSessionListener------contextInitialized----------");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        LogUtil.info("------TestHttpSessionListener------contextDestroyed----------");
    }
}
