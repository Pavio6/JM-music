package com.jlf.music.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jlf.music.enums.BaseIsPrivate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "歌单表")
@TableName(value = "playlist")
public class Playlist extends BaseEntity {
    private String title;
    private String coverImage;
    private String description;
    @Schema(description = "播放量")
    private Integer playCount;
    @Schema(description = "收藏量")
    private Integer favoriteCount;
    @Schema(description = "类型表id")
    private Integer genreId;
    @Schema(description = "是否私有")
    private BaseIsPrivate isPrivate;

}
