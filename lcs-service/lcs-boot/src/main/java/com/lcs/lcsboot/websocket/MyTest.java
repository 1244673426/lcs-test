package com.lcs.lcsboot.websocket;

import java.net.URI;
import java.net.URISyntaxException;

public class MyTest {

    public static void main(String[] arg0) {
// 此处的WebSocket服务端URI，上面服务端第2点有详细说明
        BaseWebsocketClient baseWebsocketClient = null;
        try {
            baseWebsocketClient = new BaseWebsocketClient(new URI("ws://127.0.0.1:8081/websocket"));
            baseWebsocketClient.connect();
            // 往websocket服务端发送数据
            baseWebsocketClient.send("此为要发送的数据内容");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

}