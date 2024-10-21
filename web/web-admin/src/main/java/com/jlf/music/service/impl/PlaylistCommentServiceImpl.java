package com.jlf.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jlf.music.entity.Playlist;
import com.jlf.music.entity.PlaylistComment;

import com.jlf.music.entity.PlaylistCommentLike;
import com.jlf.music.mapper.PlaylistCommentLikeMapper;
import com.jlf.music.mapper.PlaylistCommentMapper;
import com.jlf.music.mapper.UserMapper;
import com.jlf.music.service.PlaylistCommentService;

import com.jlf.music.vo.playlist.PlaylistCommentResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class PlaylistCommentServiceImpl extends ServiceImpl<PlaylistCommentMapper, PlaylistComment>
        implements PlaylistCommentService {

    @Autowired
    private PlaylistCommentMapper commentMapper;

    @Override
    public void deleteCommentById(Integer commentId) {
        // commentMapper.deleteCommentLikeByCommentId(commentId);
        commentMapper.deleteById(commentId);
    }

    @Override
    public List<PlaylistCommentResponseVo> getPlaylistCommentByPlaylistId(Integer playlistId) {
        // 获取所有评论的列表
        List<PlaylistCommentResponseVo> list = commentMapper.getPlaylistCommentByPlaylistId(playlistId);

        // 创建一个映射，存储评论ID到其在列表中的索引的映射
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < list.size(); index++) {
            map.put(list.get(index).getId(), index); // 将评论ID及其对应索引存入map
        }

        // 遍历所有评论，寻找每个评论的父节点
        for (PlaylistCommentResponseVo comment : list) {
            Integer parentId = comment.getParentCommentId(); // 获取当前评论的父节点ID

            // 如果当前评论有父节点
            if (parentId != null) {
                // 根据父节点ID获取父节点在列表中的索引
                Integer indexFather = map.get(parentId);
                // 获取父节点
                PlaylistCommentResponseVo father = list.get(indexFather);

                // 如果父节点的子节点列表为空，则初始化一个新的子节点列表
                if (father.getSubCommentList() == null) {
                    father.setSubCommentList(new ArrayList<>()); // 创建新的子节点列表
                }

                // 将当前评论添加到父节点的子节点列表中
                father.getSubCommentList().add(comment);
            }
        }
        // 1 2 5 7 10
        // 过滤出所有没有父节点的评论，即一级评论
        List<PlaylistCommentResponseVo> ans = list
                .stream() // 将list转换为Stream
                .filter(child -> child.getParentCommentId() == null) // 只保留pid为null的评论
                .collect(Collectors.toList()); // 收集过滤后的结果到List

        return ans; // 返回一级评论列表
    }

}
