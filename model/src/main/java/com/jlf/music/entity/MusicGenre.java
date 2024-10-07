package com.jlf.music.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "音乐类型表")
@TableName(value = "music_genre")
public class MusicGenre extends BaseEntity {
    @Schema(description = "类型名称")
    private String name;

}
