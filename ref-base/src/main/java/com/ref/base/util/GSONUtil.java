package com.ref.base.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by perxin on 2017/4/10.
 */
public class GSONUtil {

    public static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();

    public static <T> T fromJson(String json, Class<T> c) {
        return GSON.fromJson(json, c);
    }
}
