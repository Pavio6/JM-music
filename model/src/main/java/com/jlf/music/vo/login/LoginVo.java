package com.jlf.music.vo.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(description = "后台管理系统登录信息")
@AllArgsConstructor
public class LoginVo {
    private String username;
    private String password;
    @Schema(description = "验证码key")
    private String captchaKey;
    @Schema(description = "验证码code")
    private String captchaCode;
    public LoginVo() {

    }

}
