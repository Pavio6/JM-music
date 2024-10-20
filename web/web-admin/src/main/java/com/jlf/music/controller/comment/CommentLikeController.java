package com.jlf.music.controller.comment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jlf.music.common.result.Result;
import com.jlf.music.entity.CommentLike;
import com.jlf.music.service.CommentLikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "后台歌单评论点赞管理")
@RequestMapping("/admin/playlist/comment")
public class CommentLikeController {

    @Autowired
    private CommentLikeService commentLikeService;

    @Operation(summary = "用户点赞评论")
    @PostMapping("/userLikeComment")
    public Result userLikeComment(@RequestBody CommentLike commentLike) {
        commentLikeService.save(commentLike);
        return Result.ok();
    }
}
