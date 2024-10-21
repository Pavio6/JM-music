package com.jlf.music.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jlf.music.entity.PlaylistCommentLike;

public interface PlaylistCommentLikeService extends IService<PlaylistCommentLike> {
    int getCommentLikeCount(Integer commentId);
}
