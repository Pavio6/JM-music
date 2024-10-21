package com.jlf.music.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "歌单评论点赞表") // 描述信息
@TableName(value = "playlist_comment_like") // 指定数据库表名
public class PlaylistCommentLike extends BaseEntity{
    @Schema(description = "用户id")
    private Integer userId;
    @Schema(description = "评论id")
    private Integer commentId;
}
