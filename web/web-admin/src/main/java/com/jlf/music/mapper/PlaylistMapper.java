package com.jlf.music.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jlf.music.entity.Playlist;
import com.jlf.music.vo.song.AdminSongResponseVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PlaylistMapper extends BaseMapper<Playlist> {
    /**
     * Param 注解的作用是用于在 Mapper 接口的方法参数上进行标注  以便在 SQL 映射语句中引用这些参数
     */
    IPage<AdminSongResponseVo> getPlaylistSongsByPage(Page<AdminSongResponseVo> page, @Param("playlistId")Integer playlistId);
}
