package com.jlf.music.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jlf.music.entity.UserLike;
import com.jlf.music.vo.song.UserLikedSongVo;

import java.util.List;

public interface UserLikeService extends IService<UserLike> {
    List<UserLikedSongVo> getLikedSongs(Integer userId);
}
