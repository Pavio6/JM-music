package com.jlf.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jlf.music.entity.Singer;
import com.jlf.music.entity.Song;
import com.jlf.music.mapper.SingerMapper;
import com.jlf.music.mapper.SongMapper;
import com.jlf.music.service.SingerService;
import com.jlf.music.vo.singer.AdminSingerResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SingerServiceImpl extends ServiceImpl<SingerMapper, Singer>
        implements SingerService {
    @Autowired
    private SingerMapper singerMapper;
    @Autowired
    private SongMapper songMapper;
    @Override
    public IPage<AdminSingerResponseVo> getSingersByPage(int currentPage, int pageSize) {
        Page<AdminSingerResponseVo> page = new Page<>(currentPage, pageSize);
        // 使用BaseMapper提供的分页查询方法
        return singerMapper.selectSingersByPage(page);
    }

    @Override
//    @Transactional
    public void deleteSingerById(Integer id) {
        // 构造条件构造器
        LambdaQueryWrapper<Song> songLambdaQueryWrapper = new LambdaQueryWrapper<>();
        songLambdaQueryWrapper.eq(Song::getSingerId, id);
        // 删除歌手id对应的歌曲
        songMapper.delete(songLambdaQueryWrapper);
        // 删除歌手
        this.removeById(id);
    }
}
