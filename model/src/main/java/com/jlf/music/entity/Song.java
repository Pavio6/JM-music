package com.jlf.music.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalTime;

@Data
@Schema(description = "歌曲表")
@TableName(value = "song")
public class Song extends BaseEntity{
    @Schema(description = "关联的歌手id")
    private Integer singerId;
    private String title;
    @Schema(description = "歌词")
    private String lyrics;
    @Schema(description = "歌曲时长")
    private LocalTime duration;
    @Schema(description = "歌曲文件路径")
    private String filePath;
    @Schema(description = "封面图")
    private String imagePath;
    @Schema(description = "关联的专辑id")
    private Integer albumId;
}
