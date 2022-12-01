package com.lcs.lcsboot.service.impl;

import com.alibaba.fastjson.JSON;
import com.lcs.lcsboot.pojo.entity.LcsDevice;
import com.lcs.lcsboot.pojo.vo.CITCLocationServiceVO;
import com.lcs.lcsboot.service.LcsDeviceService;
import com.lcs.lcsboot.service.WebsocketClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @version: 1.0
 * @author: wangLei
 * @create: 2022-11-30 12:04
 **/

@Service
public class WebsocketClientServiceImpl  implements WebsocketClientService {

    @Autowired
    private LcsDeviceService lcsDeviceService;

    @Override
    public void setWebsocketMessage(String message) {
        CITCLocationServiceVO citcLocationServiceVO = JSON.parseObject(message, CITCLocationServiceVO.class);
        LcsDevice lcsDevice = new LcsDevice();
        BeanUtils.copyProperties(citcLocationServiceVO, lcsDevice);
        lcsDevice.setDeviceId(citcLocationServiceVO.getTel());
        lcsDevice.setStatus("1");

        lcsDeviceService.save(lcsDevice);
        System.out.println(citcLocationServiceVO);
    }
}
