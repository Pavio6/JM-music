package com.jlf.music.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jlf.music.entity.CommentLike;
import com.jlf.music.mapper.CommentLikeMapper;
import com.jlf.music.service.CommentLikeService;
import org.springframework.stereotype.Service;


@Service
public class CommentLikeServiceImpl extends ServiceImpl<CommentLikeMapper, CommentLike>
        implements CommentLikeService {

}
