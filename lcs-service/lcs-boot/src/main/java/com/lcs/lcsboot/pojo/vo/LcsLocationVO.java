package com.lcs.lcsboot.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @version: 1.0
 * @author: wangLei
 * @create: 2022-12-01 10:40
 **/

@ApiModel
@Data
public class LcsLocationVO {

    @ApiModelProperty("UE ID信息即被定位的终端的手机号 MSISDN。\n" +
            "取值范围：字符串类型，MSISDN的最大长度为15。举例(国家码+手机号)：8618012345678 通过密钥进行AES加密")
    @NotBlank(message = " deviceId不能为空")
    private String deviceId;

    @ApiModelProperty("应用标识,由“5G定位适配模块”提供,与密钥一一对应")
    @NotBlank(message = " appId不能为空")
    private String appId;

    @ApiModelProperty("唯一跟踪ID, appid+yyyyMMddHHmmssSSS+6位随机数")
    @NotBlank(message = " trackId不能为空")
    private String trackId;
}
