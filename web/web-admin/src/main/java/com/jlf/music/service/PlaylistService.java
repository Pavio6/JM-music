package com.jlf.music.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jlf.music.entity.Playlist;
import com.jlf.music.vo.song.AdminSongResponseVo;

public interface PlaylistService extends IService<Playlist> {
    IPage<Playlist> getAllPlayListByPage(int currentPage, int pageSize);

    IPage<Playlist> getPlaylistOfTitleByPage(int currentPage, int pageSize, String title);

    IPage<AdminSongResponseVo> getPlaylistSongsByPage(int currentPage, int pageSize, Integer playlistId);
}
