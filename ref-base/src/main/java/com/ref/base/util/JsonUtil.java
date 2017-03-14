package com.ref.base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;

/**
 * Created by perxin on 2017/1/10.
 */
public class JsonUtil {

    /**
     * JSON转为对象List
     * @param jsonString
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        return JSON.parseArray(jsonString, clazz);
    }

    /**
     * JSON转Map
     * @param jsonString
     * @return
     */
    public static Map<String, Object> jsonToMap(String jsonString) {
        return JSON.parseObject(jsonString, new TypeReference<Map<String, Object>>(){});
    }

    /**
     * JSON转对象
     * @param jsonString
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonToBean(String jsonString, Class<T> clazz) {
        return JSON.parseObject(jsonString, clazz);
    }

    /**
     * 对象转Json
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String objectToJson(T object) {
        return JSON.toJSONString(object);
    }

    /**
     * 对象转Map
     * @param bean
     * @return
     */
    public static Map<String, Object> beanToMap(Object bean) {
        return jsonToMap(objectToJson(bean));
    }
}
