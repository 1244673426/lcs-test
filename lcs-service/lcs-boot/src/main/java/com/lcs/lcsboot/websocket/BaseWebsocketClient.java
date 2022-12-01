package com.lcs.lcsboot.websocket;

import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcs.lcsboot.pojo.vo.CITCLocationServiceVO;
import com.lcs.lcsboot.service.WebsocketClientService;
import com.lcs.lcsboot.service.impl.WebsocketClientServiceImpl;
import lombok.SneakyThrows;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.net.URI;

import static com.lcs.lcsboot.controller.LcsController.flag;

/**
 * websocket客户端监听类
 *
 * @author 。
 */


public class BaseWebsocketClient extends WebSocketClient {

    private static Logger logger = LoggerFactory.getLogger(BaseWebsocketClient.class);

    private final WebsocketClientService websocketClientService =
            SpringUtil.getBean(WebsocketClientService.class);
    public BaseWebsocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        logger.info(">>>>>>>>>>>websocket open");

    }

    @SneakyThrows
    @Override
    public void onMessage(String message) {
        logger.info(">>>>>>>>>> websocket message:{}", message);
        if (message.contains("Type")){
            String str = message.replaceAll("\\\\", "");
            String substring = str.substring(1, str.length() - 1);
            System.out.println(substring);
            websocketClientService.setWebsocketMessage(substring);
        }else {
            flag =true;
        }
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        flag = true;
        logger.info(">>>>>>>>>>>websocket close");
        this.close();
    }

    @Override
    public void onError(Exception e) {
        flag = true;
        logger.error(">>>>>>>>>websocket error {}", e.getMessage());
        this.close();
    }


}

