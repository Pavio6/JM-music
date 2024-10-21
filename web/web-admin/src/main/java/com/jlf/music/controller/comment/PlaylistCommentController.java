package com.jlf.music.controller.comment;

import com.jlf.music.common.result.Result;
import com.jlf.music.entity.PlaylistComment;
import com.jlf.music.service.PlaylistCommentService;
import com.jlf.music.vo.playlist.PlaylistCommentResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "后台歌单评论管理")
@RequestMapping("/admin/playlist/comment")
public class PlaylistCommentController {

    @Autowired
    private PlaylistCommentService playlistCommentService;
    @Operation(summary = "用户对歌单评论")
    @PostMapping("addCommentToPlaylist")
    public Result addCommentToPlaylist(@RequestBody PlaylistComment playlistComment) {
        playlistCommentService.save(playlistComment);
        return Result.ok();
    }
    /**
     * TODO
     *  删除歌单评论
     *  删除comment表中id为commentId的数据 并删除comment表中parent_comment_id 为commentId 层次直到最深
     */
    @Operation(summary = "删除歌单评论")
    @DeleteMapping("deleteCommentFromPlaylist/{commentId}")
    public Result deleteCommentFromPlaylist(@PathVariable Integer commentId) {
        playlistCommentService.deleteCommentById(commentId);

        return Result.ok();
    }
    @Operation(summary = "查询歌单评论")
    @GetMapping("getAllPlaylistComment/{playlistId}")
    public Result<List<PlaylistCommentResponseVo>> getPlaylistCommentByPlaylistId(@PathVariable Integer playlistId) {
        List<PlaylistCommentResponseVo> commentList = playlistCommentService.getPlaylistCommentByPlaylistId(playlistId);
        return Result.ok(commentList);
    }
}
