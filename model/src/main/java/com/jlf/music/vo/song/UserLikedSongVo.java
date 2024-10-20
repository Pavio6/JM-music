package com.jlf.music.vo.song;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalTime;
@Data
public class UserLikedSongVo {
    @Schema(description = "歌曲名称")
    private String title;
    @Schema(description = "歌曲封面图")
    private String imagePath;
    @Schema(description = "歌手名称")
    private String singerName;
    @Schema(description = "歌曲时长")
    // 局部处理反序列化
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime duration;
    @Schema(description = "专辑名称")
    private String albumName;

}
