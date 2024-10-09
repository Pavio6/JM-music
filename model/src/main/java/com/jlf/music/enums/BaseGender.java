package com.jlf.music.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BaseGender implements BaseEnum {
    MALE(0, "男"),

    FEMALE(1, "女");


    @EnumValue
    @JsonValue
    private Integer code;

    private String name;

    BaseGender(Integer code, String name) {
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
