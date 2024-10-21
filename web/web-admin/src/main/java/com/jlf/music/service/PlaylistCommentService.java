package com.jlf.music.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jlf.music.entity.PlaylistComment;
import com.jlf.music.vo.playlist.PlaylistCommentResponseVo;

import java.util.List;

public interface PlaylistCommentService extends IService<PlaylistComment> {
    void deleteCommentById(Integer commentId);

    List<PlaylistCommentResponseVo> getPlaylistCommentByPlaylistId(Integer playlistId);
}
