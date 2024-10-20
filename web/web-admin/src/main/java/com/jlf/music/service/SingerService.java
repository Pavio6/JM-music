package com.jlf.music.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jlf.music.entity.Singer;
import com.jlf.music.vo.singer.AdminSingerResponseVo;

public interface SingerService extends IService<Singer> {
    IPage<AdminSingerResponseVo> getSingersByPage(int currentPage, int pageSize);

    void deleteSingerById(Integer id);
}
