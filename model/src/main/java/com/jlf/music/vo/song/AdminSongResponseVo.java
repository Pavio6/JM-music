package com.jlf.music.vo.song;

import com.jlf.music.entity.BaseEntity;
import lombok.Data;

import java.time.LocalTime;

@Data
public class AdminSongResponseVo {
        private Integer id;
        private String title;
        private String singer;
        private String album;
        private LocalTime duration;
}
