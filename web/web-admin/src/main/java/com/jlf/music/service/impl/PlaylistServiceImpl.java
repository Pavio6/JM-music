package com.jlf.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jlf.music.entity.Playlist;
import com.jlf.music.entity.Singer;
import com.jlf.music.mapper.PlaylistMapper;
import com.jlf.music.service.PlaylistService;
import com.jlf.music.vo.song.AdminSongResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistServiceImpl extends ServiceImpl<PlaylistMapper, Playlist>
        implements PlaylistService {
    @Autowired
    private PlaylistMapper playlistMapper;
    @Override
    public IPage<Playlist> getAllPlayListByPage(int currentPage, int pageSize) {
        return playlistMapper.selectPage(new Page<Playlist>(currentPage, pageSize), null);
    }

    @Override
    public IPage<Playlist> getPlaylistOfTitleByPage(int currentPage, int pageSize, String title) {
        LambdaQueryWrapper<Playlist> playlistLambdaQueryWrapper = new LambdaQueryWrapper<>();
        playlistLambdaQueryWrapper.like(Playlist::getTitle, title);
        return playlistMapper.selectPage(new Page<Playlist>(currentPage, pageSize), playlistLambdaQueryWrapper);
    }

    @Override
    public IPage<AdminSongResponseVo> getPlaylistSongsByPage(
            int currentPage, int pageSize, Integer playlistId) {
        Page<AdminSongResponseVo> page = new Page<>(currentPage, pageSize);
        return playlistMapper.getPlaylistSongsByPage(page, playlistId);
    }
}
