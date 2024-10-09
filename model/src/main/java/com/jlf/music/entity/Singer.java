package com.jlf.music.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jlf.music.enums.BaseGender;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "歌手表") // 描述信息
@TableName(value = "singer") // 指定数据库表名
public class Singer extends BaseEntity{
    private String name;
    private String bio;
    private BaseGender gender;
    private Date debutDate;
    private Date birthday;
    private String country;
    private String imagePath;
}
