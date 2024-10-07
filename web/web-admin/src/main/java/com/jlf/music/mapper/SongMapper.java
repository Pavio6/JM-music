package com.jlf.music.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jlf.music.entity.Song;
import com.jlf.music.vo.song.AdminSongResponseVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SongMapper extends BaseMapper<Song> {
    IPage<AdminSongResponseVo> getSongsByPage(Page<AdminSongResponseVo> page);
}
