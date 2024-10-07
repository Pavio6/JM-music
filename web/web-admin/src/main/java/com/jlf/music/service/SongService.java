package com.jlf.music.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jlf.music.entity.Song;
import com.jlf.music.vo.song.AdminSongResponseVo;

public interface SongService extends IService<Song> {
    IPage<AdminSongResponseVo> getSongsByPage(int currentPage, int pageSize);
}
