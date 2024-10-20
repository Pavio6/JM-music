package com.jlf.music.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

// @EnumValue  存储数据库的属性
// @JsonValue  返回前端界面的属性
public enum BaseIsDeleted implements BaseEnum {
    NOT_DELETED(0, "未删除"),
    DELETED(1, "已删除");


    @EnumValue
    private Integer code;
    @JsonValue
    private String name;

    BaseIsDeleted(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
