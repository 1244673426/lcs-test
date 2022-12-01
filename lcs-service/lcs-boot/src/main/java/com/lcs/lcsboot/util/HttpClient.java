//package com.lcs.lcsboot.util;
//
//
//import cn.hutool.json.JSONUtil;
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Map;
//
///**
// * Desc: 远程连接工具类
// */
//@Service
//public  class HttpClient {
//
//    /**
//     * 根据远程地址发起访问-参数类型为json-中讯服务接口
//     *
//     * @param url    远程地址
//     * @param method 远程方法
//     * @param computerLocationEntity 方法参数
//     * @return
//     */
//    public static String CITCClient(String url, HttpMethod method, ComputerLocationEntity computerLocationEntity) {
//        if (method.equals(HttpMethod.POST)) {
//            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Content-Type", "application/json");
//            HttpEntity<ComputerLocationEntity> computerLocationEntityHttpEntity = new HttpEntity<>(computerLocationEntity, headers);
//            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, computerLocationEntityHttpEntity, String.class);
//            return responseEntity.getBody();
//        } else {
//            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Content-Type", "application/json");
//            ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
//            return forEntity.getBody();
//        }
//    }
//
//    /**
//     * 根据远程地址发起访问-参数类型为JSON
//     *
//     * @param url    远程地址
//     * @param method 远程方法
//     * @aram params  方法参数
//     * @eturn
//     */
//    public Object clientJson(String url, HttpMethod method, Map<String, Object> params) {
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        JSONObject jsonObject = (JSONObject) JSONUtil.parse(params);
//        HttpEntity<JSONObject> httpEntity = new HttpEntity<>(jsonObject, headers);
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
//        String body = responseEntity.getBody();
//        JSONObject jsonObjectResult = JSONObject.parseObject(body);
//        return jsonObjectResult.get("data");
//    }
//}
