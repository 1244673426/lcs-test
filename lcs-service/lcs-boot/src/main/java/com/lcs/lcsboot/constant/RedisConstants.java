package com.lcs.lcsboot.constant;

public interface RedisConstants {

    String BUSINESS_NO_PREFIX = "business_no:";


    /**
     * 设备信息
     */
    String DEVICE_TARGET="dbdata_device_target";

    /**
     * 在线设备
     **/
    String DEVICE_TARGET_ONLINE="device_target_online:";

    /**
     * 设备位置key
     */
    String DEVICE_POSITION="track";
    /**
     * 设备类型
     */
    String DEVICE_TARGET_TYPE="dbdata_device_target_type";
    /**
     * 部门
     */
    String SYS_DEPT="dbdata_sys_dept";

    /**
     * 对象类型
     */
    String LOCAL_CONSUMER="dbdata_local_consumer";

    /**
     * 定位对象
     */
    String LOCAL_CONSUMER_ENTITY="dbdata_local_consumer_entity";

}
