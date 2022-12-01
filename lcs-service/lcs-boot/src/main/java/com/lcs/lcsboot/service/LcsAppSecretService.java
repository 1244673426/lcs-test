package com.lcs.lcsboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lcs.lcsboot.pojo.entity.LcsAppSecret;
import com.lcs.lcsboot.pojo.entity.TelInfoEntity;

import com.lcs.lcsboot.result.Result;

import java.util.List;

/**
 * @author wl
 */
public interface LcsAppSecretService extends IService<LcsAppSecret> {

    List<LcsAppSecret> listAppIds();

    Result<String> getAppSerCert(TelInfoEntity telInfo);
}
