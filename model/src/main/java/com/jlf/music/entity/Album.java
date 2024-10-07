package com.jlf.music.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "专辑表")
@TableName(value = "album")
public class Album extends BaseEntity{
    private String title;
    @Schema(description = "关联的歌手id")
    private Integer singerId;
    @Schema(description = "专辑发行时间")
    private Date releaseDate;
    @Schema(description = "关联的类型id")
    private Integer genreId;
    @Schema(description = "封面图片")
    private String coverImage;
    private String description;
}
