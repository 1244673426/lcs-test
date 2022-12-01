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
public class ComputerLocationEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     *  坐标类型 0：直接输出直角坐标,1：输出GPS坐标
     */
    @ApiModelProperty("坐标类型 0：直接输出直角坐标,1：输出GPS坐标")
    @NotBlank(message = "类型不能为空")
    private String type;

    @ApiModelProperty("订阅时间单位S ；\n" +
            "0:单次上报 非0：周期性上报\n" +
            "取值范围1~3600，步进为1；\n")
    @NotBlank(message = "time不能为空")
    private String time;

    @ApiModelProperty("tel_info格式为[\"460 01 18803345341\",\"460 01 17796925287\"]（MCC MNC TEL）")
    private List<TEL> tel_info;

    @Data
    public static class TEL {
        @NotBlank(message = " 电话号码不能为空")
        private String tel;

        @NotBlank(message = " MCC不能为空")
        private String mcc;

        @NotBlank(message = " MCC不能为空")
        private String mnc;
    }
}
