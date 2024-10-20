package com.jlf.music.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jlf.music.entity.Singer;
import com.jlf.music.vo.singer.AdminSingerResponseVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SingerMapper extends BaseMapper<Singer> {
    IPage<AdminSingerResponseVo> selectSingersByPage(Page<AdminSingerResponseVo> page);
}
