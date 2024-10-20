package com.jlf.music.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jlf.music.enums.BaseGender;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "歌单评论表") // 描述信息
@TableName(value = "comment") // 指定数据库表名
public class Comment extends BaseEntity{
    @Schema(description = "歌单id")
    private Integer playlistId;
    @Schema(description = "用户id")
    private Integer userId;
    @Schema(description = "父评论id, 用于支持回复")
    private Integer parentCommentId;
    @Schema(description = "评论内容")
    private String content;
}
