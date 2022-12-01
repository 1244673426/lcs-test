package com.lcs.lcsboot.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Slf4j
public class HttpUtil {
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/x-www-form-urlencoded";
    private static final String CONTENT_TYPE_VALUE_JSON = "application/json";

    private static RestTemplate restTemplate;

    /**
     *定义restTemplate
     * @param client
     */
    public static void setRestTemplate(RestTemplate client) {
        restTemplate = client;
    }

    /**
     * get/post请求
     * @param url
     * @param method
     * @param params
     * @return
     */
    public static Object client(String url, HttpMethod method, MultiValueMap<String, Object> params) {
        Map<String, String> setHeaders = new HashMap<>();
        setHeaders.put(CONTENT_TYPE, CONTENT_TYPE_VALUE);
        return client(url, method, params, setHeaders);
    }

    /**
     * post请求
     * @param url
     * @param params
     * @return
     */
    public static Object postClient(String url, Map<String, Object> params) {
        Map<String, String> setHeaders = new HashMap<>();
        setHeaders.put(CONTENT_TYPE, CONTENT_TYPE_VALUE_JSON);
        return clientJson(url, HttpMethod.POST, params, setHeaders);
    }

    /**
     * get请求
     * @param url
     * @param params
     * @return
     */
    public static Object getClient(String url, Map<String, Object> params) {
        Map<String, String> setHeaders = new HashMap<>();
        setHeaders.put(CONTENT_TYPE, CONTENT_TYPE_VALUE);
        return clientJson(url, HttpMethod.GET, params, setHeaders);
    }

    /**
     * get/post请求
     * @param url
     * @param method
     * @param params
     * @return
     */
    public static Object clientJson(String url, HttpMethod method, Map<String, Object> params) {
        Map<String, String> setHeaders = new HashMap<>();
        setHeaders.put(CONTENT_TYPE, CONTENT_TYPE_VALUE_JSON);
        return clientJson(url, method, params, setHeaders);
    }

    /**
     * post请求
     * @param url
     * @param params
     * @return
     */
    public static Object postClientJson(String url, Map<String, Object> params) {
        Map<String, String> setHeaders = new HashMap<>();
        setHeaders.put(CONTENT_TYPE, CONTENT_TYPE_VALUE_JSON);
        return clientJson(url, HttpMethod.POST, params, setHeaders);
    }

    /**
     * get请求
     * @param url
     * @param params
     * @return
     */
    public static Object getClientJson(String url, Map<String, Object> params) {
        Map<String, String> setHeaders = new HashMap<>();
        setHeaders.put(CONTENT_TYPE, CONTENT_TYPE_VALUE_JSON);
        return clientJson(url, HttpMethod.GET, params, setHeaders);
    }

    /**
     * form请求
     *
     * @param url
     * @param method
     * @param params MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
     *               map.add("test", "test_param");
     * @return
     */
    public static Object client(String url, HttpMethod method, MultiValueMap<String, Object> params, Map<String, String> headers) {
        log.info("url:" + url + ",params:" + params + ",headers:" + headers);
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(params, setHeaders(headers));
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, method, httpEntity, String.class, params);
        log.info("res_code:" + responseEntity.getStatusCode());
        JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
        return jsonObject.get("data");
    }

    /**
     * json请求
     *
     * @param url
     * @param method
     * @param params
     * @param headers
     * @return
     */
    public static Object clientJson(String url, HttpMethod method, Map<String, Object> params, Map<String, String> headers) {
        log.info("url:" + url + ",params:" + params + ",headers:" + headers);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(params, setHeaders(headers));
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, method, httpEntity, String.class, params);
        JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
        return jsonObject.get("data");
    }

    /**
     * 设置请求header
     *
     * @param Headers
     * @return
     */
    public static HttpHeaders setHeaders(Map<String, String> Headers) {
        HttpHeaders httpHeaders = new HttpHeaders();
        for (Map.Entry<String, String> entry : Headers.entrySet()) {
            httpHeaders.add(entry.getKey(), entry.getValue());
        }
        return httpHeaders;
    }
}