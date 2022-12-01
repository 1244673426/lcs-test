package com.lcs.lcsboot.controller;

import com.alibaba.fastjson.JSON;
import com.lcs.lcsboot.pojo.entity.ComputerLocationEntity;
import com.lcs.lcsboot.pojo.entity.LcsAppSecret;
import com.lcs.lcsboot.pojo.entity.LcsDevice;
import com.lcs.lcsboot.pojo.entity.TelInfoEntity;
import com.lcs.lcsboot.pojo.vo.CITCLocationServiceVO;
import com.lcs.lcsboot.pojo.vo.LcsLocationVO;
import com.lcs.lcsboot.result.Result;
import com.lcs.lcsboot.service.LcsAppSecretService;
import com.lcs.lcsboot.service.LcsDeviceService;
import com.lcs.lcsboot.websocket.BaseWebsocketClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.enums.ReadyState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;

import static com.lcs.lcsboot.constant.PositionConstants.URL_LBS_BBU;


/**
 * @version: 1.0
 * @author: wangLei
 * @create: 2022-11-29 11:09
 **/
@Api(tags = "lcs定位服务")
@RestController
@RequestMapping("/lcsapi/locationAdaptation")
@Slf4j
public class LcsController {

    public static Boolean flag = false;

    @Autowired
    private LcsAppSecretService lcsAppSecretService;

    @Autowired
    private LcsDeviceService lcsDeviceService;

    @PostMapping("/find")
    public Result<LcsDevice> find(@RequestBody LcsLocationVO lcsLocationVO) {
        return  lcsDeviceService.find(lcsLocationVO);
    }

    @ApiOperation("调用CITC获取用户定位")
    @PostMapping("/getCITCPosition")
    public Result<CITCLocationServiceVO> getLocation(@RequestBody @Validated ComputerLocationEntity computerLocationEntity) {
        log.info("用户信息：{}", computerLocationEntity);
        URI url = URI.create(URL_LBS_BBU);
        BaseWebsocketClient baseWebsocketClient = new BaseWebsocketClient(url);
        baseWebsocketClient.connect();
        while (!baseWebsocketClient.getReadyState().equals(ReadyState.OPEN)) {
            System.out.println("连接中。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String data = JSON.toJSONString(computerLocationEntity);
        System.out.println(data);
        if (baseWebsocketClient.getReadyState().equals(ReadyState.OPEN)){
            baseWebsocketClient.send(data);
        }
        while (!flag){
            break;
        }
        return Result.success();
    }

    @GetMapping("/appIds")
    public Result<List<LcsAppSecret>> getAppIds() {
        List<LcsAppSecret> list = lcsAppSecretService.listAppIds();
        return Result.success(list);
    }

    @PostMapping("/appSerCert")
    public Result<String> getAppSerCert(@RequestBody TelInfoEntity telInfo) {
        return lcsAppSecretService.getAppSerCert(telInfo);
    }

}
