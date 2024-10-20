package com.jlf.music.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jlf.music.entity.Comment;

import com.jlf.music.mapper.CommentMapper;
import com.jlf.music.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
        implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Override
    public void deleteCommentById(Integer commentId) {
//        commentMapper.deleteCommentLikeByCommentId(commentId);
        commentMapper.deleteById(commentId);
    }
}
