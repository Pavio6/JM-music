package com.jlf.music.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jlf.music.entity.Comment;

public interface CommentService extends IService<Comment> {
    void deleteCommentById(Integer commentId);
}
