package com.lcs.lcsboot.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.lcs.lcsboot.base.BaseEntity;
import lombok.Data;

import java.util.Map;

/**
 * @version: 1.0
 * @author: wangLei
 * @create: 2022-11-30 15:40
 **/
@Data
public class LcsDevice extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String deviceId;
    private String mapCode;
    private String trackId;
    private Double x;
    private Double y;
    private Double z;
    private Long timestamp;
    private Integer floorId;
    private String status;
    @TableLogic(value = "0", delval = "1")
    private String deleteFlag;
}
