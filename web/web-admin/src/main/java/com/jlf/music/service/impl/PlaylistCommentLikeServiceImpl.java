package com.jlf.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jlf.music.entity.PlaylistCommentLike;
import com.jlf.music.mapper.PlaylistCommentLikeMapper;
import com.jlf.music.service.PlaylistCommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlaylistCommentLikeServiceImpl extends ServiceImpl<PlaylistCommentLikeMapper, PlaylistCommentLike>
        implements PlaylistCommentLikeService {
    @Autowired
    private PlaylistCommentLikeMapper playlistCommentLikeMapper;
    @Override
    public int getCommentLikeCount(Integer commentId) {
        LambdaQueryWrapper<PlaylistCommentLike> playlistCommentLikeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        playlistCommentLikeLambdaQueryWrapper.eq(PlaylistCommentLike::getCommentId, commentId);
        Long count = playlistCommentLikeMapper.selectCount(playlistCommentLikeLambdaQueryWrapper);
        return count.intValue();
    }
}
