package com.lcs.lcsboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcs.lcsboot.pojo.entity.LcsAppSecret;
import com.lcs.lcsboot.pojo.entity.LcsDevice;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wl
 */
@Mapper
public interface LcsDeviceMapper extends BaseMapper<LcsDevice> {
}
