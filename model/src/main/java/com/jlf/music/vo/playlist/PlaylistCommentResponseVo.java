package com.jlf.music.vo.playlist;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PlaylistCommentResponseVo {
    @Schema(description = "评论id")
    private Integer id;
    @Schema(description = "父评论id")
    private Integer parentCommentId;
    @Schema(description = "评论时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @Schema(description = "评论用户名称")
    private String username;
    @Schema(description = "评论用户头像")
    private String profilePicture;
    @Schema(description = "评论内容")
    private String content;
    @Schema(description = "子评论列表")
    private List<PlaylistCommentResponseVo> subCommentList;
}
