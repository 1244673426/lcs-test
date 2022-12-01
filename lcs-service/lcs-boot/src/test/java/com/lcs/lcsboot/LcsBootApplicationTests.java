package com.lcs.lcsboot;

import com.lcs.lcsboot.pojo.entity.LcsDevice;
import com.lcs.lcsboot.service.LcsDeviceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LcsBootApplicationTests {

    @Autowired
    private LcsDeviceService lcsDeviceService;

    @Test
    void contextLoads() {
        LcsDevice lcsDevice = new LcsDevice();
        lcsDevice.setDeviceId("dfsfsf");
        lcsDeviceService.save(lcsDevice);
    }

}
