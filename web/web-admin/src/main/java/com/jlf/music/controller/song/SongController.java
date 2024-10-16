package com.jlf.music.controller.song;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jlf.music.common.result.Result;
import com.jlf.music.entity.Song;
import com.jlf.music.service.SongService;
import com.jlf.music.vo.song.AdminSongResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "后台歌曲管理")
@RestController
@RequestMapping("/admin/song")
public class SongController {
    @Autowired
    private SongService songService;
    @DeleteMapping("deleteById/{id}")
    @Operation(summary = "根据id删除歌曲")
    public Result deleteSongById(@PathVariable("id") Integer id) {
        songService.removeById(id);
        return Result.ok();
    }
    @Operation(summary = "分页查询歌曲信息")
    @GetMapping("getSongsByPage")
    public Result<IPage<AdminSongResponseVo>> getSongsByPage(
            @RequestParam(defaultValue = "1") int currentPage, // 页码
            @RequestParam(defaultValue = "10") int pageSize) {  // 数据条数
        IPage<AdminSongResponseVo> result = songService.getSongsByPage(currentPage, pageSize);
        return Result.ok(result);
    }
    @Operation(summary = "查询歌曲详细信息")
    @GetMapping("getSongById/{id}")
    public Result<Song> getSongById(@PathVariable("id") Integer id) {
        Song song = songService.getById(id);
        return Result.ok(song);
    }
    @Operation(summary = "保存或更新歌曲信息")
    @PutMapping("saveOrUpdateSong")
    public Result saveOrUpdateSong(@RequestBody Song song) {
        songService.saveOrUpdate(song);
        return Result.ok();
    }
}
