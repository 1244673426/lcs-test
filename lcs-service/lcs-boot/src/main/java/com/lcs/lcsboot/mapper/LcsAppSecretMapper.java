package com.lcs.lcsboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcs.lcsboot.pojo.entity.LcsAppSecret;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wl
 */
@Mapper
public interface LcsAppSecretMapper extends BaseMapper<LcsAppSecret> {

    /**
     * 获取appIds
     * @return appIds
     */
    List<LcsAppSecret> listAppIds();
}
