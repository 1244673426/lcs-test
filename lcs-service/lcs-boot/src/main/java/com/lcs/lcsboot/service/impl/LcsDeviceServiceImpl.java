package com.lcs.lcsboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcs.lcsboot.mapper.LcsAppSecretMapper;
import com.lcs.lcsboot.mapper.LcsDeviceMapper;
import com.lcs.lcsboot.pojo.entity.LcsAppSecret;
import com.lcs.lcsboot.pojo.entity.LcsDevice;
import com.lcs.lcsboot.pojo.vo.LcsLocationVO;
import com.lcs.lcsboot.result.Result;
import com.lcs.lcsboot.service.LcsDeviceService;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version: 1.0
 * @author: wangLei
 * @create: 2022-11-30 10:40
 **/
@Service
public class LcsDeviceServiceImpl extends ServiceImpl<LcsDeviceMapper, LcsDevice> implements LcsDeviceService {

    @Autowired

    @Override
    public Result<LcsDevice> find(LcsLocationVO lcsLocationVO) {
        System.out.println(lcsLocationVO);

        return Result.success();
    }
}
