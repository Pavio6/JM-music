package com.jlf.music.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jlf.music.entity.Song;
import com.jlf.music.mapper.SongMapper;
import com.jlf.music.service.SongService;
import com.jlf.music.vo.song.AdminSongResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song>
        implements SongService {
    @Autowired
    private SongMapper songMapper;
    @Override
    public IPage<AdminSongResponseVo> getSongsByPage(int currentPage, int pageSize) {
        Page<AdminSongResponseVo> page = new Page<>(currentPage, pageSize);
        return songMapper.getSongsByPage(page);
    }
}
