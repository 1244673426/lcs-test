package com.lcs.lcsboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcs.lcsboot.mapper.LcsAppSecretMapper;
import com.lcs.lcsboot.pojo.entity.LcsAppSecret;
import com.lcs.lcsboot.pojo.entity.TelInfoEntity;

import com.lcs.lcsboot.result.Result;
import com.lcs.lcsboot.service.LcsAppSecretService;
import com.lcs.lcsboot.util.AESUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @version: 1.0
 * @author: wangLei
 * @create: 2022-11-30 10:40
 **/
@Service
public class LcsAppSecretServiceImpl extends ServiceImpl<LcsAppSecretMapper, LcsAppSecret> implements LcsAppSecretService {
    @Autowired
    private LcsAppSecretMapper lcsAppSecretMapper;
    @Override
    public List<LcsAppSecret> listAppIds() {
        return lcsAppSecretMapper.listAppIds();
    }

    @Override
    public Result<String> getAppSerCert(TelInfoEntity telInfo) {
        String deviceId = null;
        List<LcsAppSecret> lcsAppSecrets = this.listAppIds();
        for (LcsAppSecret lcsAppSecret : lcsAppSecrets) {
            if (lcsAppSecret.getAppId().equals(telInfo.getAppId())){
                deviceId = AESUtil.encrypt(telInfo.getTel(), telInfo.getAppId());
                lcsAppSecret.setAppSecret(deviceId);
                this.save(lcsAppSecret);
                return Result.success(deviceId);
            }
        }

       return Result.failed("请输入正确appid");
    }
}
