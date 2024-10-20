package com.jlf.music.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户喜欢的歌曲记录表")
@TableName("user_likes")
public class UserLike {
    private Integer userId;
    private Integer songId;
}
