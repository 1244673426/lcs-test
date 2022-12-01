package com.lcs.lcsboot.websocket;

import com.alibaba.fastjson.JSONObject;
import org.java_websocket.enums.ReadyState;

import java.net.URI;

public class main {
    public static void main(String[] args) {
        try {
            BaseWebsocketClient myClient = new BaseWebsocketClient(new URI("ws://127.0.0.1:8081/websocket"));
            myClient.connect();
            while (!myClient.getReadyState().equals(ReadyState.OPEN)) {
                System.out.println("连接中。。。");
                Thread.sleep(3000);
                break;
            }
            // 连接成功往websocket服务端发送数据
            JSONObject object = new JSONObject();
            object.put("message", "success连接");
            myClient.send("是我啊");
            System.out.println("...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
