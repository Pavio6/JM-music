package com.jlf.music.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BaseIsActive implements BaseEnum{

    OFFLINE(0, "离线"),
    ONLINE(1, "在线");
    @EnumValue
    private Integer code;
    @JsonValue
    private String name;

    BaseIsActive(Integer code, String name) {
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
