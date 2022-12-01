package com.lcs.lcsboot.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * @version: 1.0
 * @author: wangLei
 * @create: 2022-11-17 16:36
 **/

@ApiModel
@Data
public class TelInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = " 电话号码不能为空")
    private String tel;

    @NotBlank(message = " appid不能为空")
    private String appId;

    private String mcc;

    private String mnc;


}
