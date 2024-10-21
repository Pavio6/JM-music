package com.jlf.music.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jlf.music.entity.PlaylistComment;
import com.jlf.music.vo.playlist.PlaylistCommentResponseVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlaylistCommentMapper extends BaseMapper<PlaylistComment> {

    List<PlaylistCommentResponseVo> getPlaylistCommentByPlaylistId(Integer playlistId);
}
