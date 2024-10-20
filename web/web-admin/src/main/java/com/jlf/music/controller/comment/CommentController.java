package com.jlf.music.controller.comment;

import com.jlf.music.common.result.Result;
import com.jlf.music.entity.Comment;
import com.jlf.music.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "后台歌单评论管理")
@RequestMapping("/admin/playlist/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Operation(summary = "用户对歌单评论")
    @PostMapping("addCommentToPlaylist")
    public Result addCommentToPlaylist(@RequestBody Comment comment) {
        commentService.save(comment);
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
        commentService.deleteCommentById(commentId);

        return Result.ok();
    }


}
