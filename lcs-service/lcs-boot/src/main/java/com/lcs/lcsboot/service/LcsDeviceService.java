package com.lcs.lcsboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lcs.lcsboot.pojo.entity.LcsDevice;
import com.lcs.lcsboot.pojo.vo.LcsLocationVO;
import com.lcs.lcsboot.result.Result;

/**
 * @author wl
 */

public interface LcsDeviceService extends IService<LcsDevice> {

    /**
     * 获取设备位置信息
     * @param lcsLocationVO 上下文参数
     * @return 位置信息
     */
    Result<LcsDevice> find(LcsLocationVO lcsLocationVO);
}
