package com.jlf.music.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jlf.music.common.result.Result;
import com.jlf.music.entity.Song;
import com.jlf.music.entity.UserLike;
import com.jlf.music.service.UserLikeService;
import com.jlf.music.vo.song.UserLikedSongVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "前台用户喜欢列表管理")
@RestController
@RequestMapping("/user/like")
public class UserLikeController {

    @Autowired
    private UserLikeService userLikeService;

    @Operation(summary = "获取用户喜欢的所有歌曲")
    @GetMapping("/{userId}")
    public Result<List<UserLikedSongVo>> getLikedSongsByUserId(@PathVariable Integer  userId) {
        List<UserLikedSongVo> likedSongs = userLikeService.getLikedSongs(userId);
        return Result.ok(likedSongs);
    }

    @Operation(summary = "添加喜欢的歌曲")
    @PostMapping("/{userId}/{songId}")
    public Result addLikeSong(@PathVariable Integer userId, @PathVariable Integer songId) {
        UserLike userLike = new UserLike();
        userLike.setUserId(userId);
        userLike.setSongId(songId);
        userLikeService.save(userLike);
        String message = "Song saved successfully";
        return Result.ok(message);
    }

    @Operation(summary = "取消喜欢的歌曲")
    @DeleteMapping("/{userId}/{songId}")
    public Result removeLikeSong(@PathVariable Integer userId, @PathVariable Integer songId) {
        LambdaQueryWrapper<UserLike> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(UserLike::getUserId, userId).eq(UserLike::getSongId, songId);
        userLikeService.remove(lambdaQueryWrapper);
        String message = "Song removed successfully";
        return Result.ok(message);
    }
}
