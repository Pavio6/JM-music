package com.jlf.music.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BaseIsPrivate implements BaseEnum{

    PUBLIC(0, "公开"),
    PRIVATE(1, "私有");
    @EnumValue
    private Integer code;
    @JsonValue
    private String name;

    BaseIsPrivate(Integer code, String name) {
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
