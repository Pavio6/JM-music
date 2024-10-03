package com.jlf.music.common.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
// MetaObjectHandler接口 该接口用于处理元对象的填充操作
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // 自动为createTime字段 添加当前时间
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 自动为updateTime字段 修改为当前时间
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());

    }
}
