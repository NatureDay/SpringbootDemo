package com.example.demo.util;


import com.example.demo.DemoApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 日志工具类
 */
public class LogUtil {

    private static Logger sLogger = LogManager.getLogger(DemoApplication.class);

    public static void debug(String msg) {
        sLogger.debug(msg);
    }

    public static void info(String msg) {
        sLogger.info(msg);
    }

    public static void warn(String msg) {
        sLogger.warn(msg);
    }

    public static void error(String msg) {
        sLogger.error(msg);
    }

}
