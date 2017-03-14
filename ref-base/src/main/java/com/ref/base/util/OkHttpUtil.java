package com.ref.base.util;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by perxin on 2017/2/8.
 */
public class OkHttpUtil {

    private static Logger logger = LoggerFactory.getLogger(OkHttpUtil.class);

    public static final MediaType APPLICATION_JSON = MediaType.parse("application/json; charset=utf-8");

    private static final OkHttpClient client = new OkHttpClient();

    /**
     * http 同步get方法
     * @param url
     * @return
     * @throws IOException
     */
    public static String get(String url) throws IOException{
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        }else {
            throw new IOException(response.body().string());
        }
    }

    /**
     * http 异步get方法
     * @param url
     */
    public static void getAsynchronous(String url) {
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                logger.error(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                logger.info(response.body().string());
            }
        });
    }

    /**
     * http 同步get请求 带请求头
     * @param url
     * @param headersMap
     * @return
     * @throws IOException
     */
    public static String getWithHeaders(String url, Map<String, String> headersMap) throws IOException {
        Request.Builder builder = new Request.Builder();
        if (headersMap != null) {
            for (Entry<String, String> entry : headersMap.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        Request request = builder.url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException(response.body().string());
        }
    }

    /**
     * http post方法 application/json
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(APPLICATION_JSON, json == null ? "" : json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException(response.body().string());
        }
    }

    /**
     * http 表单post提交 application/x-www-form-urlencoded
     * @param url
     * @param paramsMap 表单参数
     * @return
     * @throws IOException
     */
    public static String postForm(String url, Map<String, Object> paramsMap) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        if (paramsMap != null) {
            for (Entry<String, Object> entry : paramsMap.entrySet()) {
                builder.add(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException(response.body().string());
        }
    }

    /**
     * http 表单post上传文件 multipart/form-data
     * @param url
     * @param paramsMap
     * @return
     * @throws IOException
     */
    public static String postMultiPartForm(String url, Map<String, Object> paramsMap) throws IOException {
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (paramsMap != null) {
            for (Entry<String, Object> entry : paramsMap.entrySet()) {
                builder.addFormDataPart(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException(response.body().string());
        }
    }

}
