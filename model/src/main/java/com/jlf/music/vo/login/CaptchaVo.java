package com.jlf.music.vo.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(description = "图像验证码")
// 用于在 Java 类中自动生成一个包含所有字段的构造函数
@AllArgsConstructor
public class CaptchaVo {
    @Schema(description = "验证码图片信息")
    private String image;
    @Schema(description = "验证码key")
    private String key;
}
