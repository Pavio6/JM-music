package com.jlf.music.controller.singer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jlf.music.common.result.Result;
import com.jlf.music.entity.Singer;
import com.jlf.music.service.SingerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(name = "后台歌手管理")
@RestController
@RequestMapping("/admin/singer")
public class SingerController {
    @Autowired
    private SingerService singerService;
    @Operation(summary = "添加或更改歌手信息")
    @PostMapping("addOrUpdate")
    public Result addOrUpdateSinger(@RequestBody Singer singer) {
        // id存在时 修改歌手信息  id不存在时 添加歌手
        singerService.saveOrUpdate(singer);
        return Result.ok();
    }

    /**
     * 删除歌手的同时将歌手关联的歌曲也全部删除
     */
    @Operation(summary = "根据歌手id删除歌手")
    @DeleteMapping("deleteById/{id}")
    public Result deleteSinger(@PathVariable("id") Integer id) {
        singerService.deleteSingerById(id);
        return Result.ok();
    }
    @Operation(summary = "分页查询歌手列表")
    @GetMapping("pageSinger")
    public Result<IPage<Singer>> getSingersByPage(
            @RequestParam(defaultValue = "1") int currentPage, // 页码
            @RequestParam(defaultValue = "10") int pageSize) {
        IPage<Singer> result =  singerService.getSingersByPage(currentPage, pageSize);
        return Result.ok(result);
    }

}
