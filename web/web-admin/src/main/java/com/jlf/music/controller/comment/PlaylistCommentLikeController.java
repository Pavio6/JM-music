package com.jlf.music.controller.comment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jlf.music.common.result.Result;
import com.jlf.music.entity.PlaylistCommentLike;
import com.jlf.music.service.PlaylistCommentLikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "后台歌单评论点赞管理")
@RequestMapping("/admin/playlist/comment")
public class PlaylistCommentLikeController {

    @Autowired
    private PlaylistCommentLikeService playlistCommentLikeService;

    @Operation(summary = "用户点赞评论")
    @PostMapping("/userLikeComment")
    public Result userLikeComment(@RequestBody PlaylistCommentLike playlistCommentLike) {
        playlistCommentLikeService.save(playlistCommentLike);
        return Result.ok();
    }

    @Operation(summary = "用户取消点赞评论")
    @DeleteMapping("/userDeleteLikeComment")
    public Result userDeleteLikeComment(@RequestBody PlaylistCommentLike playlistCommentLike) {
        LambdaQueryWrapper<PlaylistCommentLike> commentLikeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        commentLikeLambdaQueryWrapper
                .eq(PlaylistCommentLike::getCommentId, playlistCommentLike.getCommentId())
                .eq(PlaylistCommentLike::getUserId, playlistCommentLike.getUserId());
        playlistCommentLikeService.remove(commentLikeLambdaQueryWrapper);
        return Result.ok();
    }
    @Operation(summary = "查询评论点赞数量")
    @GetMapping("/getCommentLikeCount")
    public Result getCommentLikeCount(@RequestParam Integer commentId) {
        int likeCount = playlistCommentLikeService.getCommentLikeCount(commentId);
        return Result.ok(likeCount);
    }
}
