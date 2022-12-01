package com.lcs.lcsboot.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * mybatis-plus 字段自动填充
 *
 * @author haoxr
 * @date 2022/7/3
 * @link https://mp.baomidou.com/guide/auto-fill-metainfo.html
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 新增填充创建时间
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createdAt", () -> LocalDateTime.now(), LocalDateTime.class);
        this.strictUpdateFill(metaObject, "updatedAt", () -> LocalDateTime.now(), LocalDateTime.class);
//        if(UserUtils.getUserId()!=null && metaObject.hasGetter("createdBy")) {
//            this.strictInsertFill(metaObject, "createdBy", () -> UserUtils.getUserId(), Long.class);
//            this.strictUpdateFill(metaObject, "updatedBy", () -> UserUtils.getUserId(), Long.class);
//        }
    }

    /**
     * 更新填充更新时间
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updatedAt", () -> LocalDateTime.now(), LocalDateTime.class);
//        if(UserUtils.getUserId()!=null && metaObject.hasGetter("createdBy") ) {
//            this.strictUpdateFill(metaObject, "updatedBy", () -> UserUtils.getUserId(), Long.class);
//        }
    }

}
