package com.jlf.music.vo.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "用户基本信息")
@Data
public class SystemUserInfoVo {
    @Schema(description = "用户名称")
    private String username;
    @Schema(description = "用户头像")
    private String profilePicture;
}
