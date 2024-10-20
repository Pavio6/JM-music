package com.jlf.music.controller.playlist;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jlf.music.common.result.Result;
import com.jlf.music.entity.Comment;
import com.jlf.music.entity.Playlist;
import com.jlf.music.service.PlaylistService;
import com.jlf.music.vo.song.AdminSongResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Tag(name = "后台歌单管理")
@RequestMapping("/admin/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @Operation(summary = "添加或修改歌单")
    @PostMapping("addOrUpdate")
    public Result addOrUpdatePlaylist(@RequestBody Playlist playlist) {
        // id存在时 修改歌单信息  id不存在时 添加歌单
        playlistService.saveOrUpdate(playlist);
        return Result.ok();
    }


    @Operation(summary = "查询所有歌单")
    @GetMapping("allPlaylist")
    public Result<IPage<Playlist>> getAllPlaylist(
            @RequestParam(defaultValue = "1") int currentPage, // 页码
            @RequestParam(defaultValue = "10") int pageSize) { // 一页的数据个数
        IPage<Playlist> result = playlistService.getAllPlayListByPage(currentPage, pageSize);
        return Result.ok(result);
    }

    @Operation(summary = "根据标题查询歌单")
    @GetMapping("playlistOfTitle")
    public Result<IPage<Playlist>> getPlaylistOfTitle(
            @RequestParam String title,
            @RequestParam(defaultValue = "1") int currentPage, // 页码
            @RequestParam(defaultValue = "10") int pageSize) {
        IPage<Playlist> result = playlistService.getPlaylistOfTitleByPage(currentPage, pageSize, title);
        return Result.ok(result);
    }
    /**
     * TODO
     *    删除歌单时 对应的歌单中的所有信息全部删除
     *    playlist_song 歌单中对应歌曲信息全部删除
     *    comment 评论表中有关要删除歌单的评论全部删除
     *    comment_like 评论点赞表中有关要删除歌单相关评论的点赞全部删除
     */
    @Operation(summary = "根据歌单id删除歌单")
    @DeleteMapping()
    public Result deletePlaylistById(@RequestParam Integer id) {

        return Result.ok();
    }

    @Operation(summary = "根据歌单id分页查询歌单中的歌曲")
    @GetMapping("getPlaylistSongs")
    public Result<IPage<AdminSongResponseVo>> getPlaylistSongs(
            @RequestParam Integer playlistId,
            @RequestParam(defaultValue = "1") int currentPage,
            @RequestParam(defaultValue = "10") int pageSize) {
        IPage<AdminSongResponseVo> result = playlistService.getPlaylistSongsByPage(currentPage, pageSize, playlistId);
        return Result.ok(result);
    }


}
