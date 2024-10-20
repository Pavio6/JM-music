package com.jlf.music.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jlf.music.enums.BaseIsActive;
import com.jlf.music.enums.BaseStatus;
import com.jlf.music.enums.BaseGender;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "用户表")
@TableName(value = "user")
public class User extends BaseEntity{
    private String username;
    private String password;
    private String email;
    private BaseGender gender;
    private BaseStatus status;
    private LocalDate birthday;
    private String bio;
    private String profilePicture;
    private BaseIsActive isActive;

}
