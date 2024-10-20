package com.jlf.music.vo.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jlf.music.enums.BaseGender;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Schema(description = "用户注册UserRegistrationVo")
@Data
public class UserRegistrationVo {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 性别
     */
    private BaseGender gender;
    /**
     * 生日
     */
    // 局部处理反序列化
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    /**
     * 简介
     */
    private String bio;
    /**
     * 头像url
     */
    private String profilePicture;

}
