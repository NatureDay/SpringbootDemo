package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;

import java.util.List;

/**
 * json工具类
 */
public class JsonUtil {

    /**
     * 对象转json字符串
     *
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        try {
            return JSON.toJSONString(obj);
        } catch (Exception e) {
            LogUtil.error("---JsonUtil---toJsonString=========" + e.getMessage());
            return "";
        }
    }

    /**
     * json字符串转对象,从json字符串解析为JSONObject
     *
     * @param json 字符串
     * @return T 实体类
     */
    public static JSONObject parseObject(String json) {
        try {
            return JSON.parseObject(json);
        } catch (Exception e) {
            LogUtil.error("---JsonUtil---parseObject=========" + e.getMessage());
            return null;
        }
    }

    /**
     * json字符串转对象,从json字符串解析为单个实体类
     *
     * @param json  字符串
     * @param clazz 实体类
     * @return T 实体类
     */
    public static <T> T parseObject(String json, Class<T> clazz) {
        try {
            return JSON.parseObject(json, clazz);
        } catch (Exception e) {
            LogUtil.error("---JsonUtil---parseObject=========" + e.getMessage());
            return null;
        }
    }

    /**
     * json字符串转JSONArray
     *
     * @param json 字符串
     * @return T
     */
    public static JSONArray parseArray(String json) {
        try {
            return JSON.parseArray(json);
        } catch (Exception e) {
            LogUtil.error("---JsonUtil---parseArray=========" + e.getMessage());
            return null;
        }
    }

    /**
     * json字符串转对象,解析多个实体类集合
     *
     * @param json  字符串
     * @param clazz 实体类
     * @return T
     */
    public static <T> List<T> parseArray(String json, Class<T> clazz) {
        try {
            return JSON.parseArray(json, clazz);
        } catch (Exception e) {
            LogUtil.error("---JsonUtil---parseArray=========" + e.getMessage());
            return null;
        }
    }

    /**
     * 从 json串中获取指定key的值
     */
    public static String getString(String json, String key) {
        if (Strings.isNullOrEmpty(json) || Strings.isNullOrEmpty(key)) return "";
        JSONObject jsonObject = parseObject(json);
        if (jsonObject == null) return "";
        String result = jsonObject.getString(key);
        if (result == null) return "";
        return result;
    }

}
