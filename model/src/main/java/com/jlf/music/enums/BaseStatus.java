package com.jlf.music.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * EnumValue注解
 * 通常用于标识枚举类中表示数据库字段的值。它的作用是指明该字段是枚举的实际值，可以在进行数据库操作时使用
 * JsonValue注解
 * 当将枚举对象序列化为 JSON 时，@JsonValue 注解的字段将作为 JSON 对象的值，而不是 enum 的名称
 */
public enum BaseStatus implements BaseEnum {


    ENABLE(1, "正常"),

    DISABLE(0, "禁用");


    @EnumValue
    private Integer code;
    @JsonValue
    private String name;

    BaseStatus(Integer code, String name) {
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
