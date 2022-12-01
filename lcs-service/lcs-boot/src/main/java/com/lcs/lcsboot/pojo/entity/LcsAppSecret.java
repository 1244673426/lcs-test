package com.lcs.lcsboot.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.xiaoymin.knife4j.annotations.Ignore;
import com.lcs.lcsboot.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @Description:
* @Author: wangLei
* @Date: 2022/11/30
*/

@Data
public class LcsAppSecret extends BaseEntity {

    @TableId(type = IdType.AUTO)
    @JsonIgnore
    private Long id;

    /**设备类型**/
    @ApiModelProperty("appid")
    private String appId;

    @ApiModelProperty("对应服务厂商")
    private String appName;

    @JsonIgnore
    private String appSecret;

    @JsonIgnore
    @TableLogic(value = "0", delval = "1")
    private String deleteFlag;


}