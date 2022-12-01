package com.lcs.lcsboot.component;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 初始化同步到redis
 * @Author: wangLei
 * @Date: 2022/12/1
 */

@Component
@RequiredArgsConstructor
public class InitDeviceCache implements CommandLineRunner {
//    private final DeviceTargetTypeService deviceTargetTypeService;
//    private final DeviceTargetService deviceTargetService;
//
//    private final LocalConsumerService localConsumerService;
//
//    private final LocalConsumerEntityService localConsumerEntityService;
    @Override
    public void run(String... args) throws Exception {
//        deviceTargetTypeService.refreshDeviceTargetTypeCache();//刷新设备类型
//        deviceTargetService.refreshDeviceTargetCache();//刷新设备
//        localConsumerService.listLocalConsumerRefresh();//刷新定位对象
//        localConsumerEntityService.listLocalConsumerEntityRefresh();//刷新对象类型
    }
}
