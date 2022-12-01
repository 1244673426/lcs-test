package com.lcs.lcsboot.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @version: 1.0
 * @author: wangLei
 * @create: 2022-11-17 17:40
 **/

@ApiModel
@Data
public class CITCLocationServiceVO {

    @ApiModelProperty("坐标类型 0：直接输出直角坐标,1：输出GPS坐标")
    private String type;

    @ApiModelProperty("UE标识为TEL（手机号）")
    private String tel;

    @ApiModelProperty("移动国家号码（MCC）")
    private String MCC;

    @ApiModelProperty("移动国家号码（MCC）")
    private String MNC;

    @ApiModelProperty("地图厂商标识:\n" +
            "0:高德 ，1：百度，3：预留\n")
    private String Mapprovider;

    @ApiModelProperty("移动国家号码（MCC）")
    private String mapId;

    @ApiModelProperty("移动国家号码（MCC）")
    private Integer floor;

    @ApiModelProperty("移动国家号码（MCC）")
    private String PCI;

    @ApiModelProperty("地图中的X坐标，单位：米")
    private Double x;

    @ApiModelProperty("地图中的Y坐标，单位：米")
    private Double y;

    @ApiModelProperty("地图中的Z坐标，单位：米.(2022年11月演示，固定为1)")
    private Double z;

    @ApiModelProperty("精度,单位：米。x1和y1为LBS估计出位置xy最近的点\n" +
            "瞬时精度：erro1 = sqrt((x-x1)^2+(y-y1)^2)\n")
    private Double insAccuracy;

    @ApiModelProperty("单位：米。瞬时精度（m）的平均值。")
    private Double accAccuracy;

    @ApiModelProperty("单位dBm。")
    private Double RSRP;

    @ApiModelProperty("单位dB。")
    private Double SINR;

    @ApiModelProperty("正整数0~65535。指示当前用户H值对应的RRU。65535表示无效值")
    private String RRU0Id;

    @ApiModelProperty("正整数0~65535。指示当前用户H值对应的RRU。65535表示无效值。")
    private String RRU1Id;

    @ApiModelProperty("正整数0~65535。指示当前用户H值对应的RRU。65535表示无效值。")
    private String RRU2Id;

    @ApiModelProperty("正整数0~65535。指示当前用户H值对应的RRU。65535表示无效值。")
    private String RRU3Id;

    @ApiModelProperty("时间信息，包括年月日时分秒。Eg：“2022-05-01-12-03-02-003”\n" +
            "2022年5月1日12时3分2秒3毫秒\n")
    private String timestamp;

}
