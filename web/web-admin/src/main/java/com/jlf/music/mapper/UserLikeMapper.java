package com.jlf.music.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jlf.music.entity.UserLike;
import com.jlf.music.vo.song.UserLikedSongVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserLikeMapper extends BaseMapper<UserLike> {
    List<UserLikedSongVo> getLikedSongs(Integer userId);
}
