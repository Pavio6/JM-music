package com.jlf.music.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jlf.music.entity.Song;
import com.jlf.music.entity.UserLike;
import com.jlf.music.mapper.UserLikeMapper;
import com.jlf.music.service.UserLikeService;
import com.jlf.music.vo.song.UserLikedSongVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLikeServiceImpl extends ServiceImpl<UserLikeMapper, UserLike>
        implements UserLikeService {
    @Autowired
    private UserLikeMapper userLikeMapper;
    @Override
    public List<UserLikedSongVo> getLikedSongs(Integer userId) {
        List<UserLikedSongVo> songList = userLikeMapper.getLikedSongs(userId);
        return songList;
    }
}
