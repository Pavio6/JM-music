package com.jlf.music.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jlf.music.entity.User;
import com.jlf.music.mapper.UserMapper;
import com.jlf.music.service.UserService;
import com.jlf.music.vo.user.UserListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public IPage<UserListVo> getUsersByPage(int currentPage, int pageSize) {
        Page<UserListVo> page = new Page<>(currentPage, pageSize);
        return userMapper.selectUsersByPage(page);
    }
}
